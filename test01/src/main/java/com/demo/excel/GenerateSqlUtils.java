package com.demo.excel;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * 类 名: GenerateSqlUtils
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2022/5/20
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class GenerateSqlUtils {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        generate();
    }

    private static void generate() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(new File(
                "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\行政区划.xlsx"));
        Sheet sheetAt = workbook.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();
        StringBuilder sb = new StringBuilder("INSERT INTO scsales_prd.T_HM_LAN_AREA" +
                "(`CITY_CODE`, `DIST_CODE`, `AREA_CODE`, `AREA_NAME`, " +
                "`START_DATE`,`CREATE_TIME`, `IS_DELETED`,`IS_HIDDEN_ROOM`) VALUES\n");
        for (int i = 1; i < lastRowNum+1; i++) {
            Row row = sheetAt.getRow(i);
            Cell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String cityCode= cell.getStringCellValue();
            Cell cell1 = row.getCell(2);
            cell1.setCellType(CellType.STRING);
            String distCode= cell1.getStringCellValue();
            String areaName=row.getCell(3).getStringCellValue();
            Long areaCode = Long.parseLong(distCode) * 10000 + i;
            sb.append("('"+cityCode+"'," +
                    "'"+distCode+"'," +
                    "'"+areaCode+"'," +
                    "'"+areaName+"'," +
                    "now()," +
                    "now()," +
                    "0,0),\n");
        }

        String s = sb.toString();
        System.err.println(s.substring(0,s.length()-2));
    }
}
