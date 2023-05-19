package com.demo.enumtest;

import lombok.Getter;

@Getter
public enum EventDomain {
    CRM("CrmOutput.OUTPUT_SERVICE", "推送客源"),
    HOUSE("HouseOutput.OUTPUT_SERVICE", "推送房源"),
    SIGN("SignOutput.OUTPUT_SERVICE", "推送签约"),
    UAM("UamOutput.OUTPUT_SERVICE", "推送uam"),
    OFFCIAL("OffcialOutput.OUTPUT_SERVICE", "推送官网"),
    BASE("BaseOutput.OUTPUT_SERVICE", "基础应用"),
    ;

    private String code;

    private String msg;

    EventDomain(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
