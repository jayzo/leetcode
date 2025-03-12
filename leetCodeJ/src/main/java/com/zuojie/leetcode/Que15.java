package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

/**
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return List.of(EMPTY_LIST);
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                return List.of(Arrays.asList(0, 1, 2));
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            List<Integer> leftList = findLeftList(nums, i);
            if (!leftList.isEmpty()) {
                ret.add(leftList);
            }
        }
        return ret;

    }

    /**
     * 从 nums里, 以cur为第一个元素, 从cur+1开始找到三个元素加和为0的元素
     * @param nums
     * @param cur
     * @return
     */
    private List<Integer> findLeftList(int[] nums, int cur) {
        return null;
    }

    public static void main(String[] args) {
        Que15 que = new Que15();
        int[] nums = {0,1,2,-1,3,-5};
        List<List<Integer>> ret = que.threeSum(nums);
        System.out.printf(JsonUtil.toJsonString(ret));
    }
}
