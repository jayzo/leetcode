package com.zuojie.leetcode.array_and_strings;

public class Solutions {
    public boolean isPalindrome435(String s) {
        int lIndex = 0;
        int rIndex = s.length() - 1;
        while (lIndex < rIndex){
            char left = s.charAt(lIndex);
            char right = s.charAt(rIndex);
            if(left >= 65 && left <= 65 +25){
                // 大写字母 变小写
                left += 32;
            }
            if(!(left >= 97 && left <= 97+25) && !(left >= 48 && left <= 57)){
                // 不是字母，数字 则忽略
                lIndex++;
                continue;
            }
            if(right >= 65 && right <= 65 +25){
                // 大写字母 变小写
                right += 32;
            }
            if(!(right >= 97 && right <= 97+25) && !(right >= 48 && right <= 57)){
                // 不是字母，数字 则忽略
                rIndex--;
                continue;
            }
            if(left != right){
                return false;
            }
            lIndex++;
            rIndex--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        Solutions solutions = new Solutions();
        System.out.println(solutions.isPalindrome435(s));
    }
}
