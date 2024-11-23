package com.zuojie.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 找出其中不含有重复字符的 最长子串 的长度
    public int lengthOfLongestSubstring(String s) {
        if(null == s || 0 == s.length()){
            return 0;
        }
        int max = 1;
        int current = 0;
        int head = 0;
        Map<String,Integer> dict = new HashMap<String, Integer>(8);
        while(head < s.length()){
            String now = String.valueOf(s.charAt(head));
            // now有重复， 记录这一子串的长度，从重复点重新统计
            if(dict.containsKey(now)){
                max = Math.max(current, max);
                current = 0;
                head = dict.get(now) + 1;
                if(max > s.length() - head){
                    break;
                }
                dict.clear();
            }else {
                dict.put(now, head);
                current++;
                head++;
            }
        }
        return Math.max(current, max);

    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    public static void main(String[] args){
        String s = "au";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
