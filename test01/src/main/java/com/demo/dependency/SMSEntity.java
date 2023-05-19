package com.demo.dependency;

import lombok.Data;

import java.util.Map;

/**
 * @author zhaochao
 * @date 2021-04-16 17:52
 */
@Data
//@Builder(toBuilder = true)
public class SMSEntity {
    //短信消息
    private String             msg;
    //手机号
    private String             phone;
    //标题
    private String             signature;
    //公司id
    private String             compid;
    //短信模版idSMSEntity
    private String             templateId;
    //短信模版内容
    private Map<String,Object> params;

}