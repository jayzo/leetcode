package com.zuojie.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jay on 17/2/15.
 */

public class Demo1 {
    public static void main(String[] args){
        Map<String, String> m = new ConcurrentHashMap<>();
        m.put("a", "test1");
        ThreadLocal<String> sMain = new ThreadLocal<>();
        sMain.set("test1");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executor.execute(() -> {
            ThreadLocal<String> s1 = new ThreadLocal<>();
            m.put("b", "test2");
            s1.set("test2");
            System.out.println(JsonUtil.toJsonString(m));
        });
        executor.shutdown();
        System.out.println(JsonUtil.toJsonString(m));
    }
}
