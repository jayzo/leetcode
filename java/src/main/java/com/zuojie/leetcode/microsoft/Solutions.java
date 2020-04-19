package com.zuojie.leetcode.microsoft;

import com.sun.deploy.util.StringUtils;

/**
 * @author zhili ZUOJIE
 * @date 2020/4/12
 */
public class Solutions {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

        //中心扩散的方法，其实做了很多重复计算。动态规划就是为了减少重复计算的问题。动态规划听起来很高大上。其实说白了就是空间换时间，将计算结果暂存起来，避免重复计算。作用和工程中用 redis 做缓存有异曲同工之妙。
        //我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
        //进入正题，动态规划关键是找到初始状态和状态转移方程。
        //初始状态，l=r 时，此时 dp[l][r]=true。
        //状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true
        //
        //作者：reedfan
        //链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        //作者：reedfan
        //链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    /**
     * https://leetcode-cn.com/explore/interview/card/microsoft/118/array-and-strings/436/
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        int size = "2147483647".length();

        int ret = 0;
        // 数字的ascii码范围是48 - 57.
        // 去掉空格
        str = str.trim();
        if(null == str || "".equals(str)){
            return 0;
        }
        boolean positive = true;
        if('-' == str.charAt(0)){
            str = str.substring(1);
            positive = false;
        }else if('+' == str.charAt(0)){
            str = str.substring(1);
            positive = true;
        }
        if(null == str || "".equals(str)){
            return 0;
        }
        // 去掉多余的0
        str = str.replaceAll("^0+","");
        int idx = 0;
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) >=48 && str.charAt(i) <= 57){
                idx++;
            }else{
                break;
            }
        }
        if(0 == idx){
            return 0;
        }
        str = str.substring(0,idx);
        if(str.length() > size){
            ret = positive ? INT_MAX : INT_MIN;
        }else if(str.length() == size){
            if(positive){
                ret = Long.parseLong(str) >= INT_MAX ? INT_MAX : Integer.parseInt(str);
            }else {
                ret =  -Long.parseLong(str) <= INT_MIN ? INT_MIN : -Integer.parseInt(str);
            }
        }else {
            ret = positive ? Integer.parseInt(str) : -Integer.parseInt(str);
        }
        return ret;
    }

    public static void main(String[] args){
        Solutions solutions = new Solutions();
        String ret = solutions.longestPalindrome("babad");
        System.out.println(ret);
        System.out.println(solutions.longestPalindrome("abb"));
        System.out.println(solutions.longestPalindrome("bba"));
        System.out.println(solutions.longestPalindrome("aabbaa"));
        System.out.println(solutions.longestPalindrome("aaaa"));

        System.out.println(solutions.myAtoi("42"));
        System.out.println(solutions.myAtoi("   -42"));
        System.out.println(solutions.myAtoi("4193 with words"));
        System.out.println(solutions.myAtoi("words and 987"));
        System.out.println(solutions.myAtoi("-91283472332"));
        System.out.println(solutions.myAtoi("3147483647"));
        System.out.println(solutions.myAtoi("3.1415"));
        System.out.println(solutions.myAtoi("+3.1415"));
        System.out.println(solutions.myAtoi("-3.1415"));
        System.out.println(solutions.myAtoi("-"));
        System.out.println(solutions.myAtoi("+"));
        System.out.println(solutions.myAtoi("  0000000000012345678"));
        System.out.println(solutions.myAtoi("-000000000000001"));
        System.out.println(solutions.myAtoi("-+1"));
        System.out.println(solutions.myAtoi("-2147483648"));
        System.out.println(solutions.myAtoi("2147483647"));
    }
}