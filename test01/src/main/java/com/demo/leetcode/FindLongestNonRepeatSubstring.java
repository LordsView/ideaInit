package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: workspace-IDEAInit
 * @description: 找出字符串中无重复字符的最长子串
 * @author: lzz
 * @create: 2022-03-15 15:05
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 */
public class FindLongestNonRepeatSubstring {

    public static void main(String[] args) {
//        System.err.println(findByImproveSolution(" "));
//        System.err.println(findByImproveSolution("bbbzcbv"));
//        System.err.println(findByImproveSolution("abcabcdf"));
//        System.err.println(findByImproveSolution("abcdafghemnca"));
        System.err.println(find("ab"));
    }

    //目前最优解-1ms
    private static int find(String s){
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    //改进解法-4ms
    private static int findByImproveSolution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    //暴力解法-100ms
    private static int findByViolentSolution(String s) {
        int maxLength = 0;
        if (s.length() == 1)
            return 1;
        for (int i = 0; i < s.length() - 1; i++) {
            Character c = s.charAt(i);
            Map<Character, Integer> map = new HashMap<>();
            map.put(c, i);
            for (int j = i + 1; j < s.length(); j++) {
                Character subC = s.charAt(j);
                if (map.containsKey(subC)) {
                    int tempLength = j - i;
                    maxLength = tempLength > maxLength ? tempLength : maxLength;
                    break;
                }
                map.put(subC, j);
                if (j == s.length() - 1 && c != subC) {
                    int tempLength = j - i + 1;
                    maxLength = tempLength > maxLength ? tempLength : maxLength;
                }

            }
        }
        return maxLength;
    }
}
