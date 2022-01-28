package com.b1aoyu.workchat.interfaces.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.b1aoyu.wechat.isv.bean.enums.EnterpriseTypeEnum;
import com.b1aoyu.wechat.isv.utils.ParseUtil;
import com.b1aoyu.wechat.isv.utils.XmlTool;
import com.b1aoyu.wechat.isv.utils.decode.AesException;
import com.b1aoyu.wechat.isv.utils.decode.WXBizJsonMsgCrypt;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseDataEnum;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseLicenseEnum;
import com.b1aoyu.workchat.application.logic.data.DataFactory;
import com.b1aoyu.workchat.application.logic.data.DataHandler;
import com.b1aoyu.workchat.application.logic.order.OrderFactory;
import com.b1aoyu.workchat.application.logic.order.OrderHandler;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：z1aoyu 2022-01-27
 * @description:企业微信控制器
 */
@RestController
@RequestMapping(value = "/app")
@Slf4j
public class WeChatController {

    @Value("${wechat.token}")
    private String token;

    @Value("${wechat.aes-key}")
    private String aesKey;

    @Value("${wechat.corp-id}")
    private String corpId;

    @Value("${wechat.suit-id}")
    private String suitId;


    /**
     * 用于验证URL
     *
     * @param signature 企业微信加密签名，msg_signature计算结合了企业填写的token、请求中的timestamp、nonce、加密的消息体。签名计算方法参考 消息体签名检验
     * @param timestamp 时间戳。与nonce结合使用，用于防止请求重放攻击。
     * @param nonce 随机数。与timestamp结合使用，用于防止请求重放攻击。
     * @param echostr 加密的字符串。需要解密得到消息内容明文，解密后有random、msg_len、msg、receiveid四个字段，其中msg即为消息内容明文
     **/
    @GetMapping(value = "data", produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "msg_signature", required = false) String signature,
            @RequestParam(name = "timestamp", required = false) String timestamp,
            @RequestParam(name = "nonce", required = false) String nonce,
            @RequestParam(name = "echostr", required = false) String echostr) throws AesException {
        WXBizJsonMsgCrypt wxcpt = new WXBizJsonMsgCrypt(token, aesKey, corpId);
        String sEchoStr = null; //需要返回的明文
        try {
            // 验证URL成功，将sEchoStr返回
            sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
        } catch (Exception e) {
            //验证URL失败，错误原因请查看异常
            log.warn("验证URL失败，错误原因请查看异常:{}", e);
            e.printStackTrace();
        }
        log.info("数据回调Get请求");
        return sEchoStr;
    }


    /**
     * 数据回调接口 用于接收托管企业微信的应用信息
     **/
    @PostMapping(value = "data", produces = "application/xml; charset=UTF-8")
    public String authPost(HttpServletRequest request, HttpServletResponse response) throws AesException, IOException {

        String res = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = XmlTool.documentToJSONObject(res);
        String toUserName = String.valueOf(jsonObject.get("ToUserName"));
        String jsonStr = jsonObject.toJSONString(0);
        Map<String, String> urlQueryMap = ParseUtil.parseUrlToMap(request);
        String msgSignature = urlQueryMap.get(EnterpriseTypeEnum.MSG_SIGNATURE.getCode());
        String timestamp = urlQueryMap.get(EnterpriseTypeEnum.TIMESTAMP.getCode());
        String nonce = urlQueryMap.get(EnterpriseTypeEnum.NONCE.getCode());
        //解析密文
        WXBizJsonMsgCrypt wxcpt = new WXBizJsonMsgCrypt(token, aesKey, toUserName);

        try {
            String sMsg = wxcpt.DecryptMsg(msgSignature, timestamp, nonce, jsonStr);
            //微信官方给的SDK这里给的是Json 但实际上解析出来是XML
            JSONObject result = XmlTool.documentToJSONObject(sMsg);
            log.info("这里是指令回调产生的数据:{}", result);
            EnterpriseDataEnum infoType = EnterpriseDataEnum
                    .of(String.valueOf(result.get(EnterpriseTypeEnum.Event.getCode())));
            DataHandler dataHandler = DataFactory.getInvokeStrategy(infoType);
            dataHandler.execute(result);
            System.out.println(infoType);
        } catch (Exception e) {
            // 解密失败，失败原因请查看异常
            e.printStackTrace();
        }
        return EnterpriseTypeEnum.SUCCESS.getCode();
    }

    /**
     * @param signature 企业微信加密签名，msg_signature计算结合了企业填写的token、请求中的timestamp、nonce、加密的消息体。签名计算方法参考 消息体签名检验
     * @param timestamp 时间戳。与nonce结合使用，用于防止请求重放攻击。
     * @param nonce 随机数。与timestamp结合使用，用于防止请求重放攻击。
     * @param echostr 加密的字符串。需要解密得到消息内容明文，解密后有random、msg_len、msg、receiveid四个字段，其中msg即为消息内容明文
     **/
    @GetMapping(value = "order", produces = "text/plain;charset=utf-8")
    public String order(@RequestParam(name = "msg_signature", required = false) String signature,
            @RequestParam(name = "timestamp", required = false) String timestamp,
            @RequestParam(name = "nonce", required = false) String nonce,
            @RequestParam(name = "echostr", required = false) String echostr) throws AesException {
        WXBizJsonMsgCrypt wxcpt = new WXBizJsonMsgCrypt(token, aesKey, corpId);
        String sEchoStr = null; //需要返回的明文
        try {
            sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
            // 验证URL成功，将sEchoStr返回
        } catch (Exception e) {
            //验证URL失败，错误原因请查看异常
            e.printStackTrace();
        }
        log.info("指令回调Get请求");
        return sEchoStr;
    }


    /**
     * 授权变更事件 及推送ticket都会走这个
     * 由于所有的授权变更事件都会往这个地方推送 但是具体指向解析出来是不同的值
     * 所以此处采用工厂+策略模式分发实现不同的 Bean对象
     **/
    @PostMapping(value = "order", produces = "application/xml; charset=UTF-8")
    public String order(HttpServletRequest request, HttpServletResponse response) throws AesException, IOException {
        String res = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = XmlTool.documentToJSONObject(res);
        String jsonStr = jsonObject.toJSONString(0);

        Map<String, String> urlQueryMap = ParseUtil.parseUrlToMap(request);
        String msgSignature = urlQueryMap.get(EnterpriseTypeEnum.MSG_SIGNATURE.getCode());
        String timestamp = urlQueryMap.get(EnterpriseTypeEnum.TIMESTAMP.getCode());
        String nonce = urlQueryMap.get(EnterpriseTypeEnum.NONCE.getCode());

        //解析密文
        WXBizJsonMsgCrypt wxcpt = new WXBizJsonMsgCrypt(token, aesKey, suitId);

        try {
            String sMsg = wxcpt.DecryptMsg(msgSignature, timestamp, nonce, jsonStr);
            //微信官方给的SDK这里给的是Json 但实际上解析出来是XML
            JSONObject result = XmlTool.documentToJSONObject(sMsg);

            EnterpriseLicenseEnum infoType = EnterpriseLicenseEnum
                    .of(String.valueOf(result.get(EnterpriseTypeEnum.INFO_TYPE.getCode())));

            if (infoType.equals(EnterpriseLicenseEnum.CHANGE_CONTACT)) {
                infoType = EnterpriseLicenseEnum
                        .of(String.valueOf(result.get(EnterpriseTypeEnum.CHANGE_TYPE.getCode())));
            }
            System.out.println(infoType);
            OrderHandler orderHandler = OrderFactory.getInvokeStrategy(infoType);
            orderHandler.execute(result);
        } catch (Exception e) {
            // 解密失败，失败原因请查看异常
            e.printStackTrace();
        }
        return EnterpriseTypeEnum.SUCCESS.getCode();
    }

}
