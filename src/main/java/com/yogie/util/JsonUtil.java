package com.yogie.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description Json转换工具类
 * @Author 陈勇洁
 * @Date 2019/11/1515:43
 **/
public class JsonUtil {

    /**
     * 将json字符串转换为JavaBean
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toClass(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    /**
     * 将JavaBean转换为json字符串
     * 将map转成json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将json字符串转成map
     *
     * @param json
     * @return
     */
    public static Map<Object, Object> toMap(String json) {
        Object jsonObj = JSON.parse(json);
        Map<Object, Object> map = (Map) jsonObj;
        return map;
    }
}