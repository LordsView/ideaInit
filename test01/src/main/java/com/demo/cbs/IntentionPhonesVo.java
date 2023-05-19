package com.demo.cbs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 意向协议电话表
 * </p>
 *
 * @author liuyuhui
 * @since 2022-08-05
 */
@Getter
@Setter
@ToString
public class IntentionPhonesVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;

}
