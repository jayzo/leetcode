package com.zuojie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。

 示例 1：

 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 输出：6
 解释：[1,1,1,0,0,1,1,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class Que1004 {
    public int longestOnes(int[] nums, int k) {
        int left=0, right = 0;
        int max = 0;
        int zeroCnt = 0;
        List<Integer> w = new ArrayList<>(nums.length);
        // 等价于滑动窗口中最多有k个0的最大窗口尺寸
        while(right < nums.length) {
            w.add(nums[right]);
            if (0 == nums[right]) {
                zeroCnt++;
            }
            right++;
            if (zeroCnt == k) {
                max = Math.max(max, w.size());
            }
            while (left < right && zeroCnt > k) {
                int l = w.get(0);
                w.remove(0);
                if (0==l){
                    zeroCnt--;
                }
            }
            if (zeroCnt == k) {
                max = Math.max(max, w.size());
            }
        }
        if (max == 0) {
            max = w.size();
        }
        return max;
    }

    public static void main(String[] args) {
        Que1004 que = new Que1004();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = que.longestOnes(nums, 3);

        System.out.println(k + "");

    }
}
