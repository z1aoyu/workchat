package com.b1aoyu.wechat.isv.utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @author：z1aoyu 2022-01-07
 * @description:
 */
public class ParseUtil {

    public static Map<String, String> parseUrlToMap(HttpServletRequest request) {
        String urlQueryString = request.getQueryString();
        Map<String, String> queryMap = new HashMap<>();
        String[] arrSplit;
        if (urlQueryString == null) {
            return queryMap;
        } else {
            //每个键值为一组
            arrSplit = urlQueryString.split("[&]");
            for (String strSplit : arrSplit) {
                String[] arrSplitEqual = strSplit.split("[=]");
                //解析出键值
                if (arrSplitEqual.length > 1) {
                    queryMap.put(arrSplitEqual[0], arrSplitEqual[1]);
                } else {
                    if (!"".equals(arrSplitEqual[0])) {
                        queryMap.put(arrSplitEqual[0], "");
                    }
                }
            }
        }
        return queryMap;
    }

}
