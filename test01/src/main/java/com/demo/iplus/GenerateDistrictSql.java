package com.demo.iplus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-06-20 16:54
 */
public class GenerateDistrictSql {

    public static void main(String[] args) throws IOException {
        generateDistrictSql();
    }

    private static void generateDistrictSql() throws IOException {
        String inputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\district.txt";
        List<String> strings = Files.readAllLines(Paths.get(inputPath));
        String outputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\districtSql.txt";
        File file = new File(outputPath);
        PrintStream ps = new PrintStream(new FileOutputStream(file));

        for (String str : strings) {
            String[] split = str.split(",");
            ps.println("INSERT INTO `T_HM_DISTRICT`(`CITY_CODE`, `DISTRICT_CODE`, `DISTRICT_NAME`, " +
                    "`DISTRICT_ABBR`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`)" +
                    " VALUES ('370800', '"+split[0]+"', '"+split[1]+"', NULL, 'SYSTEM', '2018-09-17 22:33:44.000000', 'SYSTEM', '2018-09-17 22:33:44.000000');");
        }
    }

    /*  61	 徐州公司	10062-61	10062   320300
        320302,鼓楼区
        320303,云龙区
        320305,贾汪区
        320311,泉山区
        320312,铜山区
        320321,丰县
        320322,沛县
        320324,睢宁县
        320381,新沂市
        320382,邳州市

        59    菏泽公司	10060-59	10060   371700
        371702,牡丹区
        371703,定陶区
        371721,曹县
        371722,单县
        371723,成武县
        371724,巨野县
        371725,郓城县
        371726,鄄城县
        371728,东明县

        58	  济宁公司	10059-58	10059   370800
        370811,任城区
        370812,兖州区
        370826,微山县
        370827,鱼台县
        370828,金乡县
        370829,嘉祥县
        370830,汶上县
        370831,泗水县
        370832,梁山县
        370881,曲阜市
        370883,邹城市
    * */
}
