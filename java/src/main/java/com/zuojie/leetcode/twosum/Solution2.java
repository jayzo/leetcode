package com.zuojie.leetcode.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhili ZUOJIE
 * @date 2020/3/28
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>(16);
        for(int i = 0; i< nums.length; i++){
            // 找到了当前数字的补数
            if(dict.containsKey(nums[i])){
                res[0] = i;
                res[1] = dict.get(nums[i]);
                return res;
            }
            // 补数+当前数字就是答案,所以, 记录补数和当前坐标.
            // 后面只要遇到了补数, 直接查dict就是结果
            dict.put(target - nums[i], i);
        }
        return null;
    }
    public static void main(String[] argv){

    }
}

