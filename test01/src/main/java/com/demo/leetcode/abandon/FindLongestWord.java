package com.demo.leetcode.abandon;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: workspace-IDEAInit
 * @description: 找出数组中最长的字符串
 * @author: lzz
 * @create: 2022-03-18 14:37
 *
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 * 示例 1：
 *
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 *
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母。
 *
 */
public class FindLongestWord {

    public static void main(String[] args) {
        System.err.println(find(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    private static String find(String[] words){
        Arrays.sort(words,(a,b)->{
            if(a.length()!=b.length())
                return a.length()-b.length();
            else
                return b.compareTo(a);
        });
        String longest="";
        HashSet<String> strs = new HashSet<>();
        strs.add("");
        for (int i = 0; i < words.length; i++) {
            String s=words[i];
            if (strs.contains(s.substring(0, s.length() - 1))) {
                strs.add(s);
                longest = s;
            }
        }
        return longest;
    }
}
