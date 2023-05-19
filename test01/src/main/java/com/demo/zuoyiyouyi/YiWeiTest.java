package com.demo.zuoyiyouyi;

import java.util.ArrayList;
import java.util.List;

/**
 * 左移右移测试
 */
public class YiWeiTest {

    public static void main(String[] args) {
        Long sum = 1179L;
        List<String> equipmentStrList = getEquipmentStrList(sum);
//        System.err.println(equipment.substring(1));
        System.err.println(equipmentStrList.toString());

//        Long sum = 5L;
//        //0101
//        //0100
//        //1101 13
//        long l = 5 & 1 << 2;
//        System.err.println(l);
    }

    //获取设备字符串列表
    private static List<String> getEquipmentStrList(Long sum){
        List<Long> valueArr = getValueArr(sum);
        List<String> listStringEquipment= new ArrayList<>();
        StringBuffer equipment=new StringBuffer();
        for (Long  equipments: valueArr) {
            /**
             * 转格式
             *  1=========1
             *  2=========2
             *  4=========3
             *  8=========4
             *  Math.log(Util.getIntegerValue(xxxxx)) / Math.log(2)
             */
            //求以2为底equipments的对数
            Integer j =(int) (Math.log(getIntegerValue(equipments)) / Math.log(2));
            if(j.compareTo(9)!=0){//去掉一项
                equipment.append(","+String.valueOf(j+1));
                listStringEquipment.add(String.valueOf(j+1));
            }
        }
        return listStringEquipment;
    }

    //转换为整型
    private static Integer getIntegerValue(Object obj) {
        if (null == obj || obj.toString().trim().length() == 0
                || "null".equalsIgnoreCase(obj.toString())) {
            return null;
        } else {
            try {
                return new Integer(obj.toString());
            } catch (Exception e) {
                return null;
            }
        }
    }

    //目标值转换为和为该值的数字集合（例：13->[1,4,8]）（值都为2的次幂）
    private static List<Long> getValueArr(Long sum){
        List<Long> li = new ArrayList<>();
        int i=0;
        while(1 << i < sum){
            if((sum & 1<<i) == (1<<i)){
                li.add(1L<<i);
            }
            i++;
        }
        if(1<<i == sum) li.add(sum);
        return li;
    }


}
