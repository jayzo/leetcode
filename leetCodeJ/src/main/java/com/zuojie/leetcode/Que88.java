package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
public class Que88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int cur = m + n - 1;
        while(j != -1) {
            if (i == -1 || nums2[j] > nums1[i]) {
                nums1[cur] = nums2[j];
                j--;
            } else {
                nums1[cur] = nums1[i];
                i--;
            }
            cur--;
        }
    }


    public static void main(String[] args) {
        Que88 que = new Que88();
        int[] nums1 = {1};
        int[] nums2 = {};
        que.merge(nums1, 1, nums2, 0);
        System.out.println(JsonUtil.toJsonString(nums1));
    }
}
