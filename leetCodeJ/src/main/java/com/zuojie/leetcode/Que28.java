package com.zuojie.leetcode;


import com.zuojie.leetcode.lib.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Que28 {
    public int strStr(String haystack, String needle) {
        int ret = -1;
        if (haystack.length() < needle.length()) {
            return ret;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String cur = haystack.substring(i, i+needle.length());
            if (needle.equals(cur)) {
                ret = i;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Que28 que = new Que28();
        System.out.println(JsonUtil.toJsonString(que.strStr("abc", "c")));
    }
}
