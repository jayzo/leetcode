package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que169 {
    public int majorityElement(int[] nums) {
        int gap = nums.length/2;
        Map<Integer, Integer> nodeToCountMap = new HashMap<>(16);
        for(int i : nums) {
            if (!nodeToCountMap.containsKey(i)) {
                nodeToCountMap.put(i, 1);
                if (nodeToCountMap.get(i) > gap) {
                    return i;
                }
            } else {
                nodeToCountMap.put(i, nodeToCountMap.get(i)+1);
                if (nodeToCountMap.get(i) > gap) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int ret = nums[0];
        int count = 0;
        for(int i : nums) {
            if (count == 0) {
                ret = i;
            }
            count = count + (ret == i ? 1 : -1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Que169 que = new Que169();
//        int[] nums = {0,1,2,2,2,3,6,6,7};
        int[] nums = {3,2,3};
        int k = que.majorityElement2(nums);

        System.out.printf(JsonUtil.toJsonString(nums));
        System.out.printf(k + "");

    }
}
