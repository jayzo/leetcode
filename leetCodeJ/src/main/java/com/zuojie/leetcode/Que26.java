package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */

public class Que26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int idx = 0;
        for (int i : nums) {
            if(idx == nums.length - 1) {
                // 已经找到最后一个就退出
                break;
            }
            // 依次往前找
            int cur = nums[idx];
            if (cur == i) {
                // 数字一样就继续往前
                continue;
            }
            // 数字不一样，把他复制过来
            nums[++idx] = i;
        }
        return idx+1;
    }

    public static void main(String[] args) {
        Que26 que26 = new Que26();
//        int[] nums = {0,1,2,2,3,4,4,5};
        int[] nums = {1,2};
        int k = que26.removeDuplicates(nums);

        System.out.printf(JsonUtil.toJsonString(nums));
        System.out.printf(k + "");

    }
}
