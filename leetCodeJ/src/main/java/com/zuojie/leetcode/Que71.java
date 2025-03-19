package com.zuojie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。

 示例 1：

 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 输出：6
 解释：[1,1,1,0,0,1,1,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class Que71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String gap = "/";
        for (String sec : path.split(gap)) {
//            System.out.println(sec);
            if (sec.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            if (sec.equals(".")) {
                continue;
            }
            if (sec == null || "".equals(sec)) {
                continue;
            }
            stack.push(sec);
        }
        if (stack.isEmpty()) {
            return gap;
        }
        String newPath = "";
        while(!stack.isEmpty()) {
            newPath = gap + stack.pop() + newPath;
        }
        return newPath;
    }

    public static void main(String[] args) {
        Que71 que = new Que71();
        String path = "/.../a/../b/c/../d/./";
        String newPath = que.simplifyPath(path);

        System.out.println(newPath);

    }
}
