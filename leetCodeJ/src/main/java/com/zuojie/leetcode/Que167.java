package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

 你所设计的解决方案必须只使用常量级的额外空间。
 https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que167 {
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ret = new int[2];
        while (i < j) {
            int a = numbers[i];
            int b = numbers[j];
            if (a + b == target) {
                // 找到了就返回
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
            if (a + b > target) {
                // 大于目标， 则需要减少
                j--;
            }
            if (a + b < target) {
                // 小于目标，则需要加大
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Que167 que = new Que167();
        int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1};
        int target = 2;
        int[] k = que.twoSum2(nums, target);

        System.out.printf(JsonUtil.toJsonString(k));

    }
}
