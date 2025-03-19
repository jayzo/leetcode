package com.zuojie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class Que13 {
    public int romanToInt(String s) {
        int ret = 0;
        char[] charArray = s.toCharArray();
        int idx = charArray.length - 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while (idx >= 0) {
            char cur = charArray[idx];
            char pre = idx == 0 ? '0' : charArray[idx-1];
            if (('V' ==  cur || 'X' == cur) && 'I' == pre) {
                idx -=2;
                ret += map.get(cur) - map.get(pre);
                continue;
            }
            if (('L' ==  cur || 'C' == cur) && 'X' == pre) {
                idx -=2;
                ret += map.get(cur) - map.get(pre);
                continue;
            }
            if (('D' ==  cur || 'M' == cur) && 'C' == pre) {
                idx -=2;
                ret += map.get(cur) - map.get(pre);
                continue;
            }
            idx--;
            ret += map.get(cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        Que13 que = new Que13();
        System.out.println(que.romanToInt("MCMXCIV"));
    }
}
