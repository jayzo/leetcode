package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//必须在不使用库内置的 sort 函数的情况下解决这个问题。
//
//示例 1：
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//示例 2：
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//提示：
//
//n == nums.length
//1 <= n <= 300
//nums[i] 为 0、1 或 2
public class Que75 {
    public void sortColors(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i = j; i < nums.length; i++) {
            nums[i] = 2;
        }

        int k = 0;
        for(int i = 0; i < j; i++) {
            if (nums[i] == 0) {
                nums[k] = 0;
                k++;
            }
        }
        for(int i = k; i < j; i++) {
            nums[i] = 1;
        }
    }


    public static void main(String[] args) {
        Que75 que = new Que75();
        int[] nums = {2,0,1};
        que.sortColors(nums);
        System.out.println(JsonUtil.toJsonString(nums));
    }
}
