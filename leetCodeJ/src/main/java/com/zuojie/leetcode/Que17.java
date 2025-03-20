package com.zuojie.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 */
public class Que17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> codeMap = new HashMap<>();
        codeMap.put('2', Arrays.asList("a", "b", "c"));
        codeMap.put('3', Arrays.asList("d", "e", "f"));
        codeMap.put('4', Arrays.asList("g", "h", "i"));
        codeMap.put('5', Arrays.asList("j", "k", "l"));
        codeMap.put('6', Arrays.asList("m", "n", "o"));
        codeMap.put('7', Arrays.asList("p", "q", "r", "s"));
        codeMap.put('8', Arrays.asList("t", "u", "v"));
        codeMap.put('9', Arrays.asList("w", "x", "y", "z"));
        char[] digitArray = digits.toCharArray();
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.isBlank()) {
            return Collections.EMPTY_LIST;
        }
        char first = digitArray[0];
        if (digits.length() == 1) {
            return codeMap.get(first);
        }
        int last = digitArray.length - 1;
        return getList(codeMap, 0, last, digitArray);
    }
    List<String> getList(Map<Character, List<String>> codeMap, int from, int to, char[] digitArray) {
        if (from == to) {
            return codeMap.get(digitArray[to]);
        }
        List<String> ret = new ArrayList<>();
        char first = digitArray[from];
        for(String letter : codeMap.get(first)) {
            List<String> curRet = getList(codeMap, from + 1, to, digitArray);
            ret.addAll(curRet.stream().map(o-> letter + o).collect(Collectors.toList()));
        }
        return ret;
    }

    public static void main(String[] args) {
        Que17 que = new Que17();
        System.out.println(que.letterCombinations("3"));
        System.out.println(que.letterCombinations("23"));
        System.out.println(que.letterCombinations("24"));
        System.out.println(que.letterCombinations("456"));
    }
}
