package com.ulovecode.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 2017-07-04 01:30
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    public static Object fromJson(String json,Class clazz) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return  gson.fromJson(json, clazz);
    }


}
