package com.zuojie.leetcode.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhili ZUOJIE
 * @date 2020/3/28
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Long, List<Integer>> dict = new HashMap<Long, List<Integer>>();
        for(int i = 0; i< nums.length; i++){
            if(!dict.containsKey((long)nums[i])){
                dict.put((long)nums[i], new ArrayList<Integer>());
            }
            dict.get((long)nums[i]).add(i);
        }
        for(Long one :dict.keySet()){
            // find one
            if(dict.containsKey(target - one)){
                res[0] = dict.get(one).get(0);
                res[1] = one == target - one ? dict.get(one).get(1) : dict.get(target - one).get(0);
                return res;
            }
        }
        return null;
    }
    public static void main(String[] argv){

    }
}

