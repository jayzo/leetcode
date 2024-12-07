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
    public int[] twoSum(int[] numbers, int target) {
        // 遍历numbers
        // 第i个元素是a, b=target - a
        // b < a 直接continue
        // 在剩余数组中二分查找b，找不到也continue
        // 找到b了，返回a,b
        // 整个时间复杂度n*logn
        int[] ret = new int[2];
        // 记录 当前元素是否能找到结果
        Map<Integer, Integer> m = new HashMap<>(1);
        for (int i = 0; i< numbers.length - 1; i++) {
            int a = numbers[i];
            ret[0] = i + 1;
            int b = target - a;
            if(m.containsKey(a) && m.get(a) == -1) {
                continue;
            }
            if (b < a) {
                continue;
            }
            System.out.println("a:"+a);
            System.out.println("b:"+b);
            int j = halfFind(i + 1, numbers.length - 1, numbers, b);
            if (j > 0) {
                ret[1] = j + 1;
                return ret;
            } else {
                m.put(a, -1);
            }
        }
        return ret;
    }

    private int halfFind(int from, int to, int[] numbers, int target) {
        System.out.println("from:" + from);
        System.out.println("to:" + to);
        while(from < to) {
            if(numbers[from] == numbers[from+1]) {
                from = from + 1;
            } else {
                break;
            }
        }
        if(to - from == 1) {
            if (numbers[from] == target) {
                return from;
            }
            if (numbers[to] == target) {
                return to;
            }
            return -1;
        }
        int mid = (from + to) / 2;
        if (target == numbers[mid]) {
            return mid;
        }

        if (from == mid) {
            return  -1;
        }
        return target < numbers[mid] ? halfFind(from, mid-1, numbers, target) : halfFind(mid + 1, to, numbers, target);
    }

    public static void main(String[] args) {
        Que167 que = new Que167();
        int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1};
        int target = 2;
        int[] k = que.twoSum(nums, target);

        System.out.printf(JsonUtil.toJsonString(k));

    }
}
