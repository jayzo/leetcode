package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_LIST;

/**
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                return List.of(Arrays.asList(nums[0] , nums[1] , nums[2]));
            }
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<String> added = new HashSet<>();
        for (int i = 0 ; i< nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    String key = nums[i] +"_" + nums[j] +"_" + nums[k];
//                    System.out.println(key);
                    if (!added.contains(key)) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        added.add(key);
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        Que15 que = new Que15();
//        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
//        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> ret = que.threeSum(nums);
        System.out.printf(JsonUtil.toJsonString(ret));
    }
}
