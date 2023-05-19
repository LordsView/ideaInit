package com.demo.cbs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 意向协议用户表
 * </p>
 *
 * @author liuyuhui
 * @since 2022-08-05
 */
@Setter
@Getter
@ToString
public class SignIntentionUsersVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long proxyType;

    private String fullname;

    private String idcardNo;

    private List<IntentionPhonesVo> userPhone;

}
