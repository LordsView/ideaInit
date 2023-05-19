package com.demo.excel;

import com.demo.excel.entity.Building;
import com.demo.excel.entity.House;
import com.demo.excel.entity.Unit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 类 名: EstateSplitUtils
 * 描 述: 楼盘框架拆分（房号非标）
 * 作 者: LZZ
 * 创 建： 2022/5/19
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class EstateSplitUtils {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        split();
    }

    private static void split() throws IOException, InvalidFormatException {
        Set<Building> buildingSet = new LinkedHashSet<>();
        Set<Unit> unitSet = new LinkedHashSet<>();
        Set<House> houseSet = new LinkedHashSet<>();
        Workbook workbook = new XSSFWorkbook(new File(
                "D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\楼盘字典-房号非标.xlsx"));
        Sheet sheetAt = workbook.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();
        for (int i = 1; i < lastRowNum; i++) {
            Row row = sheetAt.getRow(i);
            String districtName = row.getCell(3).getStringCellValue();//行政区名
            String areaName = row.getCell(5).getStringCellValue();//片区名
            String estateName = row.getCell(6).getStringCellValue();//楼盘名称
            Cell cell17 = row.getCell(18);
            String buildingCodeStr = row.getCell(19).getStringCellValue();//栋座编号
            cell17.setCellType(CellType.STRING);
            String buildFor = cell17.getStringCellValue();//建筑用途
            String suffix = row.getCell(20).getStringCellValue();//后缀
            if (buildingCodeStr.indexOf("、") > 0) {
                String[] split = buildingCodeStr.split("、");
                for (String s : split) {
                    Building building = new Building();
                    building.setBuildingCode(s);
                    building.setDistrictName(districtName);
                    building.setAreaName(areaName);
                    building.setEstateName(estateName);
                    building.setBuildFor(buildFor);
                    building.setSuffix(suffix);
                    buildingSet.add(building);
                }
            } else if (buildingCodeStr.indexOf("-") > 0) {
                char[] chars = buildingCodeStr.toCharArray();
                char start = chars[0];
                char end = chars[2];
                while(start<=end){
                    Building building = new Building();
                    building.setBuildingCode(start+"");
                    building.setDistrictName(districtName);
                    building.setAreaName(areaName);
                    building.setEstateName(estateName);
                    building.setBuildFor(buildFor);
                    building.setSuffix(suffix);
                    buildingSet.add(building);
                    start+=1;
                }
            }else{
                Building building = new Building();
                building.setBuildingCode(buildingCodeStr);
                building.setDistrictName(districtName);
                building.setAreaName(areaName);
                building.setEstateName(estateName);
                building.setBuildFor(buildFor);
                building.setSuffix(suffix);
                buildingSet.add(building);
            }
        }
        Workbook workbook1 = new XSSFWorkbook();
        Sheet newBuildingSheet = workbook1.createSheet();
        Row row = newBuildingSheet.createRow(0);
        row.createCell(0).setCellValue("行政区名");
        row.createCell(1).setCellValue("片区名");
        row.createCell(2).setCellValue("楼盘名称");
        row.createCell(3).setCellValue("建筑用途");
        row.createCell(4).setCellValue("栋座编号");
        row.createCell(5).setCellValue("后缀");

        int rowNum=1;
        for (Building building : buildingSet) {
            Row row1 = newBuildingSheet.createRow(rowNum);
            row1.createCell(0).setCellValue(building.getDistrictName());
            row1.createCell(1).setCellValue(building.getAreaName());
            row1.createCell(2).setCellValue(building.getEstateName());
            row1.createCell(3).setCellValue(building.getBuildFor());
            row1.createCell(4).setCellValue(building.getBuildingCode());
            row1.createCell(5).setCellValue(building.getSuffix());
            rowNum++;
        }
        FileOutputStream out = new FileOutputStream("D:\\WorkSpaces\\workspace-IDEAInit\\test01\\src\\main\\resource\\楼栋表-房号非标.xlsx");
        workbook1.write(out);
        out.flush();
        //释放资源
        out.close();
        workbook1.close();
        System.err.println("拆分成功");
    }


}
