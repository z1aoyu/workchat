package com.b1aoyu.workchat.interfaces.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.b1aoyu.workchat.common.utils.decode.AesException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：z1aoyu 2022-01-27
 * @description:企业微信控制器
 */
@RestController
@RequestMapping(value = "/app")
@Slf4j
public class WeChatController {


    /**
     * 数据回调接口 用于接收托管企业微信的应用信息
     **/
    @PostMapping(value = "data", produces = "application/xml; charset=UTF-8")
    public String authPost(HttpServletRequest request, HttpServletResponse response) throws AesException, IOException {

        return null;
    }

}
