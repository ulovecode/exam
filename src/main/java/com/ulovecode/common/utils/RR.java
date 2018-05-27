package com.ulovecode.common.utils;

import java.util.HashMap;

/**
 * @author JackZhu
 * @since 2018/05/06
 */
public class RR extends HashMap<String, Object> {
    private HashMap<String, Object> data = new HashMap<>();


    private RR() {
        put("data", data);
    }

    public static RR ok() {
        RR rr = new RR();
        rr.put("code", 0);
        return rr;
    }

    public RR put(String key,Object value) {
        super.put(key, value);
        return this;
    }


    public RR dataPut(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public  static RR  error() {
        RR rr = new RR();
        rr.put("message", "未知错误信息");
        rr.put("error", "错误");
        return rr;
    }
    public  static RR  error(String message,String error) {
        RR rr = new RR();
        rr.put("message", message);
        rr.put("error", error);
        return rr;
    }

}

