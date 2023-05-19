package com.demo.excel.entity;

/**
 * 类 名: Unit
 * 描 述: 单元实体类
 * 作 者: LZZ
 * 创 建： 2022/5/19
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class Unit {
    //行政区名
    private String districtName;

    //片区名
    private String areaName;

    //楼盘名称
    private String estateName;

    //栋座编号
    private String buildingCode;

    //单元号
    private String unitCode;

    //起始楼层
    private String startFloor;

    //终止楼层
    private String endFloor;

    //总楼层
    private String totalFloor;

    //完工年份
    private String finishYear;

    //建筑类型
    private String buildType;

    //朝向
    private String toward;

    //电梯数
    private String liftNum;

    //几户
    private String houseNum;

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + estateName.hashCode() + buildingCode.hashCode() + unitCode.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Unit unit = (Unit) obj;
        return districtName.equals(unit.getDistrictName())
                && areaName.equals(unit.getAreaName())
                && estateName.equals(unit.getEstateName())
                && buildingCode.equals(unit.getBuildingCode())
                && unitCode.equals(unit.getUnitCode())
                && startFloor.equals(unit.getStartFloor())
                && endFloor.equals(unit.getEndFloor())
                && totalFloor.equals(unit.getTotalFloor())
                && finishYear.equals(unit.getFinishYear())
                && buildType.equals(unit.getBuildType())
                && toward.equals(unit.getToward())
                && liftNum.equals(unit.getLiftNum())
                && houseNum.equals(unit.getHouseNum());
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

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getStartFloor() {
        return startFloor;
    }

    public void setStartFloor(String startFloor) {
        this.startFloor = startFloor;
    }

    public String getEndFloor() {
        return endFloor;
    }

    public void setEndFloor(String endFloor) {
        this.endFloor = endFloor;
    }

    public String getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(String totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(String finishYear) {
        this.finishYear = finishYear;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getLiftNum() {
        return liftNum;
    }

    public void setLiftNum(String liftNum) {
        this.liftNum = liftNum;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }
}
