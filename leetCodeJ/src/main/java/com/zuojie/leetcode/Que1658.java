package com.zuojie.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class Que1658 {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target == 0) {
            return nums.length;
        }
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int curSum= 0;
        int minStep = -1;
        List<Integer> window = new LinkedList<>();
        while (right < nums.length) {
            // 窗口右滑
            window.add(nums[right]);
            curSum += nums[right];
            right++;
            if (curSum == target) {
                if (-1 == minStep) {
                    minStep = nums.length - window.size();
                } else {
                    minStep = Math.min(nums.length - window.size(), minStep);
                }
            }
            while (left < right && curSum > target) {
                int l = window.get(0);
                window.remove(0);
                left++;
                curSum = curSum - l;
            }
            if (curSum == target) {
                if (-1 == minStep) {
                    minStep = nums.length - window.size();
                } else {
                    minStep = Math.min(nums.length - window.size(), minStep);
                }
            }
        }
        return minStep;
    }

    public static void main(String[] args) {
        Que1658 que = new Que1658();
        int[] nums = {5,2,3,1,1};
        int k = que.minOperations(nums, 5);

        System.out.println(k + "");

    }
}
