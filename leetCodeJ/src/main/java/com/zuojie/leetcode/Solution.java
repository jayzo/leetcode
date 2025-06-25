package com.zuojie.leetcode;

import com.zuojie.leetcode.lib.JsonUtil;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            // 扩大窗口
            sum += nums[r++];
            // 没到target, 继续扩大窗口
            if (sum < target) {
                continue;
            }
            // 减小窗口至sum不再超
            while (sum >= target) {
                sum -= nums[l];
                l++;
            }
            // 记录一次答案
            ans = ans == 0 ? r-l+1 : Math.min(ans, r-l+1);
        }
        return ans;
    }


    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        System.out.println(JsonUtil.toJsonString(s.minSubArrayLen(11, nums)));
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