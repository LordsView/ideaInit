package com.demo.iplus;

/**
 * 类 名: Generate_T_SM_SG_BS_Sql
 * 描 述: 生成组队盘关系表插入sql
 * 作 者: LZZ
 * 创 建： 2022/5/24
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class Generate_T_SM_SG_BS_Sql {

    //注：str，为参数，需要通过实际参数传入，有多个用逗号隔开
    public static void main(String[] args) {
        String str = "57C4EFCEF91E11ECAED40A38EB3BF0E2";
        String sql = "INSERT INTO T_SM_SG_BS(BUSISWZ_ID,BUILDSET_ID,PLEVEL,CREATE_BY) " +
                "SELECT " +
                "t.sgid, " +
                "t.bid, " +
                "GROUP_CONCAT( t.`view` ) ," +
                "'lzz20221011'" +
                "FROM " +
                "T_SM_SG_BS_WUHAN t  " +
                "WHERE " +
                "sgid = '0d487b65cf064ca29e4258bdb31c7b11'  and `view` IS NOT NULL " +
                "GROUP BY " +
                "t.sgid, " +
                "t.bid;";
        String[] st = str.trim().split(",");
        String[] view = new String[]{"view","own","act","key","exp","tra","inf","nor","sole","xndh","weihu","RP","CKFH"};
        String result = "";
        for(int j=0;j<view.length;j++){
            for (int i = 0;i<st.length;i++){
                result = sql.replace("view",view[j]);
                result = result.replace("0d487b65cf064ca29e4258bdb31c7b11",st[i]);
                System.out.println(result);
            }
        }
    }

}
