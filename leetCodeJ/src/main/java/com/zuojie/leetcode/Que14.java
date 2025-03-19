package com.zuojie.leetcode;

import java.util.*;

/**
 */
public class Que14 {
    public String longestCommonPrefix(String[] strs) {

        int size = strs.length;
        if(size == 0) {
            return "";
        }

        if(size == 1) {
            return strs[0];
        }
        char[] commonArr = strs[0].toCharArray();
        int retSize = commonArr.length;
        int idx = 1;
        while (idx < strs.length) {
            char[] curArray = strs[idx].toCharArray();
            idx++;
            // 通过common和cur更新common
            char[] newCommon = new char[retSize];
            for(int i = 0; i< commonArr.length; i++) {
                if (i >= curArray.length) {
                    break;
                }
                if (commonArr[i] != curArray[i]) {
                    break;
                }
                if (commonArr[i] == curArray[i]) {
                    newCommon[i] = commonArr[i];
                }
                retSize = i + 1;
            }
            commonArr = newCommon;
        }
        String ret = "";
        for (char c : commonArr) {
            if (c == '\0') {
                break;
            }
            ret = ret + c;
        }
        return ret;
    }

    public static void main(String[] args) {
        Que14 que = new Que14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(que.longestCommonPrefix(strs));
    }
}
