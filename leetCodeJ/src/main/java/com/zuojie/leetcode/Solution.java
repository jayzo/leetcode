package com.zuojie.leetcode;

<<<<<<< HEAD

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
=======
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                return List.of(Arrays.asList(nums[0], nums[1], nums[2]));
            }
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<String> added = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    String key = nums[i] + "_" + nums[j] + "_" + nums[k];
//                    System.out.println(key);
                    if (!added.contains(key)) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        added.add(key);
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
>>>>>>> 337eb1cd5b5f0bb1d0342b8f6081861f74c78177
        }
        return ret;
    }

<<<<<<< HEAD
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
=======

    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
//        while(true) {
//            threadPoolExecutor.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(100L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            Thread.sleep(1000L);
//        }
    }
}
>>>>>>> 337eb1cd5b5f0bb1d0342b8f6081861f74c78177
