package com.b1aoyu.wechat.isv.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections.MapUtils;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * @author：z1aoyu 2022-01-27
 * @description: 基于okHttp的工具类封装
 */
@Slf4j
public class HttpUtil {

    private HttpUtil() {
    }

    public static final String TYPE_WWW_FORM = "application/x-www-form-urlencoded; charset=utf-8";

    public static final String TYPE_JSON = "application/json; charset=utf-8";

    public static final MediaType CONTENT_TYPE_JSON = MediaType.parse(TYPE_JSON);

    public static final int READ_TIMEOUT = 10;


    /**
     * get请求
     */
    public static Response get(String url, Map<String, String> paramMap) throws IOException {
        if (MapUtils.isNotEmpty(paramMap)) {
            boolean flag = true;
            StringBuilder urlBuilder = new StringBuilder(url);
            for (Entry<String, String> entry : paramMap.entrySet()) {
                if (flag) {
                    urlBuilder.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                    flag = false;
                } else {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
            url = urlBuilder.toString();
        }

        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(url).build(); // 创建一个请求
        Response response = okHttpClient.newCall(request).execute(); // 返回实体
        if (response.isSuccessful()) { // 判断是否成功
            return response;
        } else {
            log.error("get 请求失败，{}", JSONUtil.toJsonStr(response));
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * post  json提交
     *
     * @param url 接口路径
     * @param json 入参消息体
     * @param headMap 入参头部  非必填
     */
    public static Response postJson(String url, String json, Map<String, String> headMap) throws IOException {
        if (headMap == null) {
            headMap = new HashMap<>();
        }
        headMap.put("Content-Type", TYPE_JSON);
        RequestBody requestBody = RequestBody.create(CONTENT_TYPE_JSON, json);
        return post(url, requestBody, headMap);
    }


    /**
     * @param url 接口路径
     * @param bodyMap 入参消息体
     * @param headMap 头部参数 非必填
     */
    public static Response postForm(String url, Map<String, String> bodyMap, Map<String, String> headMap) throws IOException {
        headMap.put("Content-Type", TYPE_WWW_FORM);
        FormBody.Builder builder = new FormBody.Builder();
        if (MapUtils.isNotEmpty(bodyMap)) {
            for (Entry<String, String> stringStringEntry : bodyMap.entrySet()) {
                builder.add(stringStringEntry.getKey(), stringStringEntry.getValue());
            }
        }
        RequestBody requestBody = builder.build();
        return post(url, requestBody, headMap);
    }

    private static Response post(String url, RequestBody requestBody, Map<String, String> headMap) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).followRedirects(false).build();

        Headers.Builder builder = new Headers.Builder();
        if (MapUtils.isNotEmpty(headMap)) {
            for (Entry<String, String> entry : headMap.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        Request request = new Request.Builder().url(url).post(requestBody).headers(builder.build()).build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
