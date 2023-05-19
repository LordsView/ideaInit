package com.demo.data_type;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @program: workspace-IDEAInit
 * @description: bigdecimal 测试
 * @author: lzz
 * @create: 2022-02-09 16:47
 */
public class TestBigDecimal {
    public static void main(String[] args) {
//        testMultiply();
//        testFormat1();
//        testFormat2();
//        testFormat3();
        testMultiply2();
    }

    //乘运算
    private static void testMultiply(){
        float score = 86.8f;
        Float esScores = null;
        BigDecimal scoresBig = new BigDecimal(Float.toString(score));
        esScores = scoresBig.multiply(new BigDecimal(100)).floatValue();
        System.err.println(esScores);
    }

    /**
     * 保留几位小数
     *
     * BigDecimal.ROUND_HALF_UP 和 BigDecimal.ROUND_HALF_DOWN 都表示四舍五入
     *
     * ROUND_UP，只要弃位非0就进一位
     *
     * ROUND_DOWN，不管如何都不会进位
     *
     * ROUND_CEILING，向正无穷方向舍入
     *若为正数，类似于ROUND_UP
     *若为负数，类似于ROUND_DOWN
     *例子1：123.466777保留两位小数结果为123.47
     *例子2：-123.466777保留两位小数结果为123.46
     *
     * ROUND_FLOOR，向负无穷方向舍入
     * 若为负数，类似于ROUND_UP
     * 若为正数，类似于ROUND_DOWN
     * 例子1：123.466777保留两位小数结果为123.46
     * 例子2：-123.466777保留两位小数结果为123.47
     * */
    private static void testFormat1() {
        double value = 10D/3;
        BigDecimal bigDecimal = new BigDecimal(value);
        BigDecimal scale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(scale);
    }

    //保留两位小数
    private static void testFormat2(){
        double d = 123.456;
        String result = String.format("%.2f",d);
        System.out.println(result);
    }

    //保留两位小数
   private static void testFormat3(){
       DecimalFormat decimalFormat = new DecimalFormat("#.##");
       System.out.println(decimalFormat.format(3.336D));
   }

   private static void testMultiply2(){
       BigDecimal b1 = new BigDecimal(Double.toString(0.2));
       BigDecimal b2 = new BigDecimal(Double.toString(100));
       BigDecimal m = b1.multiply(b2);
       System.out.println(m);
   }
}
