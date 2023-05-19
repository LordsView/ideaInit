package com.demo.leetcode;

/**
 * @program: workspace-IDEAInit
 * @description: 整数反转
 * @author: lzz
 * @create: 2022-03-18 14:48
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.err.println(reverse2(-123));
    }

    //循环计算方式123-321
    private static int reverse1(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    //字符串反转
    private static int reverse2(int x) {
        int flag = 1;
        String s = String.valueOf(x);
        if (x < 0) {
            flag = -1;
            s = s.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuilder(s).reverse().toString()) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
