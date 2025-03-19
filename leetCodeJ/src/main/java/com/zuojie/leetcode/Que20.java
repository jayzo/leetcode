package com.zuojie.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 */
public class Que20 {
    public boolean isValid(String s) {
        if ("".equals(s) || null == s) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char in = stack.peek();
            boolean match = false;
            if (')' == c && '(' == in) {
                match = true;
            }
            if ('}' == c && '{' == in) {
                match = true;
            }
            if (']' == c && '[' == in) {
                match = true;
            }
            if (match) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Que20 que = new Que20();
        System.out.println(que.isValid("()"));
        System.out.println(que.isValid("()[]{}"));
        System.out.println(que.isValid("(]"));
    }
}
