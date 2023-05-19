package com.demo.Leetcode_test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-03-24 11:26
 */
public class ValidParentheses {

    //{()[]}
    private static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' | c == '{')
                stack.push(c);
            else if (stack.isEmpty()
                    || c == ')' && stack.pop() != '('
                    || c == ']' && stack.pop() != '['
                    || c == '}' && stack.pop() != '{')
                return false;

        }
        return stack.isEmpty();
    }
}
