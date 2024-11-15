package com.zuojie.leetcode.rain;

import com.zuojie.leetcode.microsoft.Solutions;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution {

    /**
     * 总的接雨水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int volume = 0;
        int[] heightLine = height;
        while (true) {
            if (needBreak(heightLine)) {
                break;
            }
            int singleLineVolume = trapSingleLine(heightLine);
            heightLine = updateHeightLine(heightLine);
            volume += singleLineVolume;
        }
        return volume;
    }

    private boolean needBreak(int[] heightLine) {
        // 全0则不需要update
        // 所有非零元素都在一起且单调, 不需要update
        boolean allZero = true;
        boolean monotonicUp = true;
        boolean monotonicDown = true;
        boolean allTogether = true;
        int firstNoZeroIndex = 0;
        int firstZeroIndex = 0;
        for (int i = 0; i < heightLine.length; i++) {
            if (heightLine[i] != 0 && allZero) {
                allZero = false;
            }

            if (heightLine[i] != 0 && firstNoZeroIndex == 0) {
                firstNoZeroIndex = i;
            }

            if (heightLine[i] == 0 && firstNoZeroIndex > 0) {
                firstZeroIndex = i;
            }

            if (i > 0 && heightLine[i] < heightLine[i - 1]) {
                monotonicUp = false;
            }
            if (i > 0 && heightLine[i] > heightLine[i - 1]) {
                monotonicDown = false;
            }
            // 已存在一个0元素,非零元素在0元素后又遇到了
            if (i > firstZeroIndex && heightLine[i] > 0 && firstZeroIndex > 0) {
                allTogether = false;
            }
        }
        return (allTogether && (monotonicUp || monotonicDown)) || allZero;
    }

    private int[] updateHeightLine(int[] heightLine) {
        int[] heightLineNew = new int[heightLine.length];
        for (int i = 0; i< heightLine.length; i++) {
            int val = heightLine[i];
            heightLineNew[i] = val > 0 ? val - 1 : val;
        }
        return heightLineNew;
    }

    /**
     * 只看第一层能接多少雨水
     * @param height
     * @return
     */
    private int trapSingleLine(int[] height) {
        int val = 0;
        int left = 0;
        int right = height.length - 1;
        int current = 0;
        while (left != right) {
            if (current == right) {
                break;
            }
            if (height[left] == 0) {
                left++;
            }
            if (height[right] == 0) {
                right--;
            }

            if (current > left && height[current] == 0) {
                val++;
            }

            current++;
        }
        return val;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] s1 = new int[]{4,2,0,3,2,5};
//        int[] s1 = new int[]{4,2,3};
        int ret1 = solution.trap(s1);
        System.out.println(ret1);
    }
}
