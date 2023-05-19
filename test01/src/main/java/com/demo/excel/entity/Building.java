package com.demo.excel.entity;

/**
 * 类 名: Building
 * 描 述: 栋座实体类
 * 作 者: LZZ
 * 创 建： 2022/5/19
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class Building {

    //行政区名
    private String districtName;

    //片区名
    private String areaName;

    //楼盘名称
    private String estateName;

    //建筑用途
    private String buildFor;

    //栋座编号
    private String buildingCode;

    //后缀-栋
    private String suffix;

    @Override
    public int hashCode() {
        int result=17;
        result=31*result+estateName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Building building = (Building) obj;
        return districtName.equals(building.getDistrictName())
                && areaName.equals(building.getAreaName())
                && estateName.equals(building.getEstateName())
                && buildFor.equals(building.getBuildFor())
                && buildingCode.equals(building.getBuildingCode())
                && suffix.equals(building.getSuffix());
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getBuildFor() {
        return buildFor;
    }

    public void setBuildFor(String buildFor) {
        this.buildFor = buildFor;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
