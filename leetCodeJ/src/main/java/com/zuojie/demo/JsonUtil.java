package com.zuojie.demo;

import com.google.gson.Gson;

public class JsonUtil {
    private static Gson gson = new Gson();
    public static String toJsonString(Object obj) {
        return gson.toJson(obj);
    }
}
