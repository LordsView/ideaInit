package com.demo.data_type;

/**
 * @program: workspace-IDEAInit
 * @description: 进制转换
 * @author: lzz
 * @create: 2022-03-23 14:43
 *
 * 原码表示法规定：用符号位和数值表示带符号数，正数的符号位用“0”表示，负数的符号位用“1”表示，数值部分用二进制形式表示。
 * 反码表示法规定：正数的反码与原码相同，负数的反码为对该数的原码除符号位外各位取反。
 * 补码表示法规定：正数的补码与原码相同，负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1.
 * 正零和负零的补码相同，[+0]补=[-0]补=0000 0000B
 *
 * 例：-5
 * 原码：10000000 00000000 00000000 00000101
 * 反码：11111111 11111111 11111111 11111010
 * 补码：11111111 11111111 11111111 11111011
 *
 * 计算机中负数用补码表示
 *
 */
public class BinaryConversion {

    public static void main(String[] args) {
        int i = 15;
        System.err.println("二进制:"+Integer.toBinaryString(i));
        System.err.println("右移一位:"+ (i >> 1));
//        System.err.println("八进制:"+Integer.toOctalString(i));
//        System.err.println("十六进制:"+Integer.toHexString(i));
        decimalToBinary(10);
    }

    private static void decimalToBinary(int n){
        String str ="";
        while(n!=0){
            str= n%2+str;
            n/=2;
        }
        System.err.println(str);
    }
}
