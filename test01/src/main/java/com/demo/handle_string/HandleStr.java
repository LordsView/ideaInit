package com.demo.handle_string;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-04-27 13:38
 */
public class HandleStr {

    public static void main(String[] args) throws IOException {
        String s = "select count(*) a,'' as tableName from crm_prd.T_CM_CONTACT union all\n" +
                "select count(*) a,'' as tableName from crm_prd.T_CM_CUS";
//        WriteStrToFile(handleStr(s));
//        handleMergeFile();
        handleInitFile();
    }


    private static void handleMergeFile() throws IOException {
        String inputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\sql.txt";
        List<String> strings = Files.readAllLines(Paths.get(inputPath));
        String outputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\temp.txt";
        File file = new File(outputPath);
        PrintStream ps = new PrintStream(new FileOutputStream(file));

        for (String str : strings) {
            int unionAll = str.indexOf("union all");
            if (str.length() < 23) {
                ps.println(str);
            } else {
                String s1;
                if (unionAll > 0) {
                    s1 = str.substring(39, unionAll - 1);
                } else {
                    s1 = str.substring(39);
                }
                String s2 = str.replaceAll("''", "'" + s1 + "'");
                ps.println(s2);
            }
        }
    }

    private static void handleInitFile() throws IOException {
        String inputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\sql.txt";
        List<String> strings = Files.readAllLines(Paths.get(inputPath));
        String outputPath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\temp.txt";
        File file = new File(outputPath);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println("select tableName,count from (");
        for (String str : strings) {
            int begin = str.indexOf("where");
            int end = str.indexOf("57");
            String s1 = str.substring(begin-1, end + 2);
            String s = str.replaceAll(s1, "");
            String s3 = s.replaceAll("',", "' tableName,");
            String s2 = s3.replaceAll("from", "count from");
            ps.println(s2);
        }
        ps.println(") t WHERE count>0");
    }

    private static String handleStr(String s) {
        String[] alls = s.split("union all");
        List<String> list = new ArrayList<>();
        for (String str :
                alls) {
            String s1 = str.substring(39);
            String s2 = str.replaceAll("''", "'" + s1 + "'");
            list.add(s2);
        }
        return String.join("union all", list);
    }


    @Test
    public void testRead() throws IOException {
        String s = "select count(*) a,'' as tableName from crm_prd.T_CM_CONTACT";
        int unionAll = s.indexOf("union all");
        System.err.println(unionAll);
    }

    private static void writeStrToFile(String s) throws FileNotFoundException {
        String filePath = "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\temp.txt";
        File file = new File(filePath);

        PrintStream ps = new PrintStream(new FileOutputStream(file));

        // 往文件里写入字符串
        ps.println(s);

    }
}
