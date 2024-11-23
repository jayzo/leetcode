package com.zuojie.leetcode;

import com.google.gson.Gson;
import com.zuojie.demo.JsonUtil;
import com.zuojie.demo.Pojo1;

import java.util.Arrays;

public class Que27 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        if (nums.length == 0) {
            return k;
        }
        int idx = 0;
        int tail = nums.length - 1;
        while (true) {
            // 循环nums, 退出条件为当前下标 idx > tail
            // 当前元素 != val: k++; idx++; continue, 如idx == tail则break
            // 当前元素 == val: idx == tail的话break; 否则tail -> cur; tail前移; continue
            int cur = nums[idx];
            if (cur == val) {
                if (idx == tail) {
                    break;
                }
                nums[idx] = nums[tail];
                tail--;
            } else {
                k++;
                if (idx == tail) {
                    break;
                }
                idx++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Que27 que27 = new Que27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = que27.removeElement(nums, val);

        System.out.printf(JsonUtil.toJsonString(nums));
        System.out.printf(k + "");

    }
}
