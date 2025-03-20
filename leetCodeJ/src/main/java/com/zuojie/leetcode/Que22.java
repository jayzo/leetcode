package com.zuojie.leetcode;


import com.zuojie.demo.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Que22 {
    public List<String> generateParenthesis(int n) {
        List res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder builder = new StringBuilder();
        dfs(builder, n, 0, 0, res);
        return res;
    }

    // 从某个括号数开始, 遍历找到合适的结果
    private void dfs(StringBuilder builder, int n, int left, int right, List<String> res) {
        // 右括号多了一定不符合, 没画够数量一定不符合
        if (right > left || right > n || left > n) {
            return;
        }
        // 遍历过程中发现有合适的结果, 加入结果集
        if (left == n && right == n) {
            res.add(builder.toString());
            return;
        }
        // 从左括号开始遍历
        builder.append(')');
        dfs(builder, n, left, right + 1, res);
        // 遍历完之后回退
        builder.deleteCharAt(builder.length() - 1);

        // 从右括号再开始遍历
        builder.append('(');
        dfs(builder, n, left + 1, right, res);
        // 遍历后回退
        builder.deleteCharAt(builder.length() - 1);
    }

    public static void main(String[] args) {
        Que22 que = new Que22();
        System.out.println(JsonUtil.toJsonString(que.generateParenthesis(5)));
    }
}
