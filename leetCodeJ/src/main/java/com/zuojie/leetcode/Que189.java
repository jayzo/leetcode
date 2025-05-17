package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

import java.util.Arrays;

/**
 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Que189 {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] copy = Arrays.copyOf(nums, size);
        int gap = k % size;
        for (int i = 0; i< size; i++) {
            int pos = (i + gap) % size;
            nums[pos] = copy[i];
        }
    }

    public static void main(String[] args) {
        Que189 que = new Que189();
        int[] nums = {0,0,1,2};
        que.rotate(nums, 3);
        System.out.printf(JsonUtil.toJsonString(nums));
    }
}
