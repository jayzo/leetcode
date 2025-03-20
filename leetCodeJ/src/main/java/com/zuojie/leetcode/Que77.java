package com.zuojie.leetcode;

import com.zuojie.demo.JsonUtil;
import com.zuojie.leetcode.lib.ListNode;

import java.util.*;

/**
 */
public class Que77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> allNum = new ArrayList<>();
        List<Integer> oneRet = new ArrayList<>();
        for (int j = 1; j<=n; j++) {
            allNum.add(j);
        }
        backTrace(allNum, oneRet, k, ret);
        return ret;
    }

    void backTrace(List<Integer> numList, List<Integer> oneRet, int cnt, List<List<Integer>> ret) {
        if (cnt == oneRet.size()) {
            ret.add(new ArrayList<>(oneRet));
        }
        for (int i: numList) {
            if (oneRet.contains(i)) {
                continue;
            }
            if (!oneRet.isEmpty() && oneRet.get(oneRet.size() - 1) > i) {
                continue;
            }
            oneRet.add(i);
            backTrace(numList, oneRet, cnt, ret);
            oneRet.remove((Integer) i);
        }
    }


    public static void main(String[] args) {
        Que77 que = new Que77();
        System.out.println(JsonUtil.toJsonString(que.combine(10,7)));

    }
}
