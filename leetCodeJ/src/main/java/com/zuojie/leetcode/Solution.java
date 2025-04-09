package com.zuojie.leetcode;


import com.zuojie.demo.JsonUtil;
import com.zuojie.leetcode.lib.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        List<TreeNode> s = Arrays.asList(root);
        while (!s.isEmpty()) {
            System.out.println(JsonUtil.toJsonString(s));
            List<Integer> retList = new ArrayList<>();
            List<TreeNode> nextList = new ArrayList<>();
            for(TreeNode o : s) {
                retList.add(o.val);
                if (o.left != null) {
                    nextList.add(o.left);
                }
                if (o.right != null) {
                    nextList.add(o.right);
                }
                s = nextList;
            }
            ret.add(retList);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(JsonUtil.toJsonString(solution.levelOrder(root)));
    }
}
