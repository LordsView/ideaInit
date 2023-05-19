package com.demo.excel.entity;

/**
 * 类 名: House
 * 描 述: 房号表
 * 作 者: LZZ
 * 创 建： 2022/5/19
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class House {

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

    //楼层
    private String floor;

    //房号
    private String houseCode;

    //物业类型
    private String propertyType;

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + estateName.hashCode()
                + buildingCode.hashCode()
                + unitCode.hashCode()
                + floor.hashCode()
                + houseCode.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        House house = (House) obj;
        return districtName.equals(house.getDistrictName())
                && areaName.equals(house.getAreaName())
                && estateName.equals(house.getEstateName())
                && buildingCode.equals(house.getBuildingCode())
                && unitCode.equals(house.getUnitCode())
                && floor.equals(house.getFloor())
                && houseCode.equals(house.getHouseCode());
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
