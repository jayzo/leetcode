package com.zuojie.leetcode;

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
        }
        return ret;
    }


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