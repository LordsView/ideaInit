package com.demo.dependency;

public enum SmsSendTemCode {
	SALES("SMS_RECEIVE_SALES","售房"),
	RENT("SMS_RECEIVE_RENT","租房"),
	SALESRENT("SMS_RECEIVE_SALES_RENT","租售");

	/**
	 * code
	 */
	String code;

	/**
	 * name
	 */
	String name;

	SmsSendTemCode(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
