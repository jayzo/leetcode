package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class Que46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> oneRet = new ArrayList<>();
        dfs(nums, oneRet, ret);
        return ret;
    }

    void dfs(int[] nums, List<Integer> oneRet, List<List<Integer>> ret) {
        if (oneRet.size() == nums.length) {
            ret.add(new ArrayList<>(oneRet));
            return;
        }
        for (int i : nums) {
            if (oneRet.contains(i)) {
                continue;
            }
            oneRet.add(i);
            dfs(nums, oneRet, ret);
            oneRet.remove(oneRet.size() - 1);
        }
    }

    public static void main(String[] args) {
        Que46 que = new Que46();
        int [] nums = {1,2};
        System.out.println(JsonUtil.toJsonString(que.permute(nums)));

    }
}
