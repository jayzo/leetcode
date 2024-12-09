package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;

/**
 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。

 说明：你不能倾斜容器。
 https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que11 {
    public int maxArea(int[] height) {
        // 从两头找起,哪边短就移动哪边,直到两边相遇
        // 遇到矮的直接pass, 遇到高的要重算area,更新maxArea
        if (height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            if (i > 0 && height[i] <= height[i-1]) {
                i++;
                continue;
            }
            if (j < height.length - 1 && height[j] <= height[j+1]) {
                j--;
                continue;
            }
            int left = height[i];
            int right = height[j];
            int area = calcArea(left, right, j-i);
            maxArea = Math.max(maxArea, area);
//            System.out.printf("left[%s] = %s, right[%s] = %s, maxArea:%s%n", i, left, j, right, maxArea);
            if (left <= right) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    private int calcArea(int left, int right, int gap) {
        int height = Math.min(left, right);
        return height * gap;
    }

    public static void main(String[] args) {
        Que11 que = new Que11();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int k = que.maxArea(nums);

        System.out.printf(k + "");

    }
}
