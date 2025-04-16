package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Que80 {
    public int removeDuplicates(int[] nums) {
        int u = 0;
        for (int x : nums) {
            // u小于2的话，原地复制
            // 当前x和结果指针的前2个位置不一样，则说明x需要成为结果
            // 判断完后，u++处理下一个位置
            if (u < 2 || nums[u - 2] != x) nums[u++] = x;
        }
        return u;

//        作者：宫水三叶
//        链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/702970/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static void main(String[] args) {
        Que80 que = new Que80();
//        int[] nums = {0,1,2,2,2,3,6,6,7};
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int k = que.removeDuplicates(nums);

        System.out.printf(JsonUtil.toJsonString(nums));
        System.out.printf(k + "");

    }
}
