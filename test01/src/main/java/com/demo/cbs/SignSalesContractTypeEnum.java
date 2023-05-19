package com.demo.cbs;

import java.util.HashMap;
import java.util.Map;

/**
 * 合同枚举类
 * @author chenyuan
 *
 */
public class SignSalesContractTypeEnum {

	/**
	 * 合同状态( 1:签约中;2：成交;3：作废;4：退单申请中; 5:退单进行中;6:已退单)
	 * @author chenyuan
	 *
	 */
	public static enum ContractStatus{
		ContractStatusOne("1","签约中"),
		ContractStatusTwo("2","成交"),
		ContractStatusThree("3","作废"),
		ContractStatusFour("4","退单申请中"),
		ContractStatusFive("5","退单进行中"),
		ContractStatusSix("6","已退单");

		public String key;
		public String value;
		ContractStatus(String key ,String value){
			this.key = key ;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}

		private static Map<String,ContractStatus> maps = new HashMap<String,ContractStatus>();
		static{
			for(ContractStatus cs : ContractStatus.values()){
				maps.put(cs.key, cs);
			}
		}
		public static ContractStatus get(final String key) {
			ContractStatus cs = maps.get(key);
			if (cs == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ContractStatus.class.getName(), key));
			}
			return cs;
		}
		public static String getValue(String key) {
			if(get(key)==null){
				return null;
			}else{
				return get(key).value;
			}
		}
	}

	/**
	 * 合同类型：1租赁,2买卖
	 * @author chenyuan
	 *
	 */
	public static enum ContractType{
		ContractTypeOne("1","租赁"),
		ContractTypeTwo("2","买卖"),
		ContractTypeThree("3","租赁迁移合同"),
		ContractTypeFour("4","买卖迁移合同");

		public String key;
		public String value;
		ContractType(String key ,String value){
			this.key = key ;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}


		private static Map<String,ContractType> maps = new HashMap<String,ContractType>();
		static{
			for(ContractType cs : ContractType.values()){
				maps.put(cs.key, cs);
			}
		}
		public static ContractType get(final String key) {
			ContractType cs = maps.get(key);
			if (cs == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ContractType.class.getName(), key));
			}
			return cs;
		}
		public static String getValue(String key) {
			if(get(key)==null){
				return null;
			}else{
				return get(key).value;
			}
		}
	}


	/**
	 * 合同报备状态（包含线下和线上）
	 * @author chenyuan
	 *REPORTED_AUDIT_STATUS
	 */
	public static enum ReportedAuditAllStatus{
		ReportedAuditStatusOne("1","待提交报备审核"),
		ReportedAuditStatusTwo("2","报备审核中"),
		ReportedAuditStatusThree("3","报备审核通过"),
		ReportedAuditStatusFour("4","报备审核驳回"),
		ReportedAuditStatusFiveZN("5","报备审核通过(智能核验)");

		public String key;
		public String value;
		ReportedAuditAllStatus(String key ,String value){
			this.key = key ;
			this.value = value;
		}
		private static Map<String,ReportedAuditAllStatus> maps = new HashMap<String,ReportedAuditAllStatus>();
		static{
			for(ReportedAuditAllStatus ls : ReportedAuditAllStatus.values()){
				maps.put(ls.key, ls);
			}
		}
		public static ReportedAuditAllStatus get(final String key) {
			ReportedAuditAllStatus ls = maps.get(key);
			if (ls == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ReportedAuditAllStatus.class.getName(), key));
			}
			return ls;
		}
		public static String getValue(String key) {
			if(get(key)==null){
				return null;
			}else{
				return get(key).value;
			}
		}
	}

	/**
	 * 证件类型
	 * @author chenyuan
	 *
	 */
	public static enum IdcardType{
		IdcardTypeOne("1","居民身份证"),
		IdcardTypeTwo("2","军（警）身份证"),
		IdcardTypeThree("3","香港居民身份证"),
		IdcardTypeFour("4","澳门居民身份证"),
		IdcardTypeFive("5","台湾居民身份证"),
		IdcardTypeSix("6","护照"),
		IdcardTypeSeven("7","台湾居民来往大陆通行证（台胞证）"),
		IdcardTypeEight("8","军官证"),
		IdcardTypeNine("9","企业组织机构代码"),
		IdcardTypeTen("10","营业执照"),
		IdcardTypeEleven("11","统一社会信用代码"),
		IdcardTypeTwelve("12","港澳居民来往内地通行证"),
		IdcardTypeThirteen("13","户口簿"),
		IdcardType_14("14","出生证"),
		IdcardType_16("16","港澳台身份证"),
		IdcardType_19("19","其他"),
		IdcardType_20("20","回乡证"),
		IdcardType_21("21","军官证"),
		IdcardType_22("22","大陆来往证"),
		IdcardType_23("23","法人代码证"),
		IdcardType_24("24","社团法人登记证"),
		IdcardType_27("27","法人的营业执照企业代码证"),
		;
		public String key;
		public String value;
		IdcardType(String key ,String value){
			this.key = key ;
			this.value = value;
		}
//		private static Map<String, SignSalesContractType.IdcardType> maps = new HashMap<String, SignSalesContractType.IdcardType>();
//		static{
//			for(SignSalesContractType.IdcardType ls : SignSalesContractType.IdcardType.values()){
//				maps.put(ls.key, ls);
//			}
//		}
//		public static SignSalesContractType.IdcardType get(final String key) {
//			SignSalesContractType.IdcardType ls = maps.get(key);
//			if (ls == null) {
//				System.out.println(String.format("%s没有对应值,key=%s", SignSalesContractType.IdcardType.class.getName(), key));
//			}
//			return ls;
//		}
//		public static String getValue(String key) {
//			if(get(key)==null){
//				return null;
//			}else{
//				return get(key).value;
//			}
//		}
	}

	public static enum EbsCustTrxStatus {
		EbsCustTrxStatusOne("1", "发票"),
		EbsCustTrxStatusTwo("2", "发票-A"),
		EbsCustTrxStatusThree("3", "贷项通知单-A"),
		EbsCustTrxStatusFour("4", "贷项通知单");

		public String key;
		public String value;
		private static Map<String, EbsCustTrxStatus> maps = new HashMap();

		private EbsCustTrxStatus(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public static EbsCustTrxStatus get(String key) {
			EbsCustTrxStatus cs = (EbsCustTrxStatus)maps.get(key);
			if (cs == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ContractStatus.class.getName(), key));
			}

			return cs;
		}

		public static String getValue(String key) {
			return get(key) == null ? null : get(key).value;
		}

		static {
			EbsCustTrxStatus[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				EbsCustTrxStatus cs = var0[var2];
				maps.put(cs.key, cs);
			}

		}
	}

	public static enum EbsContractStatus {
		EbsContractStatusOne("1", "签订"),
		EbsContractStatusTwo("2", "已审核"),
		EbsContractStatusThree("3", "已作废"),
		EbsContractStatusFour("4", "已解约"),
		EbsContractStatusFive("5", "已过户"),
		EbsContractStatusSix("6", "逾期"),
		EbsContractStatusSeven("7", "业务完结");

		public String key;
		public String value;
		private static Map<String, EbsContractStatus> maps = new HashMap();

		private EbsContractStatus(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

//		public static EbsContractStatus get(String key) {
//			EbsContractStatus cs = (EbsContractStatus)maps.get(key);
//			if (cs == null) {
//				System.out.println(String.format("%s没有对应值,key=%s", SignSalesContractType.ContractStatus.class.getName(), key));
//			}
//
//			return cs;
//		}

//		public static String getValue(String key) {
//			return get(key) == null ? null : get(key).value;
//		}

		static {
			EbsContractStatus[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				EbsContractStatus cs = var0[var2];
				maps.put(cs.key, cs);
			}

		}
	}

	public static enum DiscountStatus {
		DiscountStatus_1(1L, "待提交折扣审核"),
		DiscountStatus_2(2L, "折扣审核中"),
		DiscountStatus_3(3L, "折扣审核通过"),
		DiscountStatus_4(4L, "折扣审核驳回");

		public Long key;
		public String value;

		private DiscountStatus(Long key, String value) {
			this.key = key;
			this.value = value;
		}

		public static String getValue(Long key) {
			if (key == null) {
				return null;
			} else {
				DiscountStatus[] var1 = values();
				int var2 = var1.length;

				for(int var3 = 0; var3 < var2; ++var3) {
					DiscountStatus discountStatus = var1[var3];
					if (discountStatus.key.equals(key)) {
						return discountStatus.value;
					}
				}

				return null;
			}
		}
	}


	public static enum ProxyUserType {
		ProxyUserTypeOne("1", "业主信息"),
		ProxyUserTypeTwo("2", "业主共有人信息"),
		ProxyUserTypeThree("3", "业主代理人信息"),
		ProxyUserTypeFour("4", "客户信息"),
		ProxyUserTypeFive("5", "客户共有人信息"),
		ProxyUserTypeSix("6", "客户代理人信息"),
		ProxyUserTypeSeven("7", "共有权人代理人信息(甲方)"),
		ProxyUserTypeEight("8", "共同购买人代理人信息（乙方）"),
		ProxyUserTypeNine("9", "客户未成年子女信息（乙方）"),
		ProxyUserTypeTen("10", "客户共有人未成年子女信息（乙方）"),
		ProxyUserTypeEleven("11", "丙方（居间方）");

		public String key;
		public String value;
		private static Map<String, ProxyUserType> maps = new HashMap();

		private ProxyUserType(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public static ProxyUserType get(String key) {
			ProxyUserType ls = (ProxyUserType)maps.get(key);
			if (ls == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ProxyUserType.class.getName(), key));
			}

			return ls;
		}

		public static String getValue(String key) {
			return get(key) == null ? null : get(key).value;
		}

		static {
			ProxyUserType[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				ProxyUserType ls = var0[var2];
				maps.put(ls.key, ls);
			}

		}
	}

	public static enum ProxyUserTypeAlias {
		ProxyUserTypeOne("1", "甲方"),
		ProxyUserTypeTwo("2", "甲方共有人"),
		ProxyUserTypeThree("3", "甲方代理人"),
		ProxyUserTypeFour("4", "乙方"),
		ProxyUserTypeFive("5", "乙方共有人"),
		ProxyUserTypeSix("6", "乙方代理人"),
		ProxyUserTypeSeven("7", "共有权人代理人信息(甲方)"),
		ProxyUserTypeEight("8", "共同购买人代理人信息（乙方）"),
		ProxyUserTypeNine("9", "客户未成年子女信息（乙方）"),
		ProxyUserTypeTen("10", "客户共有人未成年子女信息（乙方）"),
		ProxyUserTypeEleven("11", "丙方（居间方）");

		public String key;
		public String value;
		private static Map<String, ProxyUserTypeAlias> maps = new HashMap();

		private ProxyUserTypeAlias(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public static ProxyUserTypeAlias get(String key) {
			ProxyUserTypeAlias ls = (ProxyUserTypeAlias)maps.get(key);
			if (ls == null) {
				System.out.println(String.format("%s没有对应值,key=%s", ProxyUserType.class.getName(), key));
			}

			return ls;
		}

		public static String getValue(String key) {
			return get(key) == null ? null : get(key).value;
		}

		static {
			ProxyUserTypeAlias[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				ProxyUserTypeAlias ls = var0[var2];
				maps.put(ls.key, ls);
			}

		}
	}


	public static enum ChangeName {
		ChangeName_0(1L, "未过户"),
		ChangeName_1(2L, "已过户"),
		ChangeName_2(3L, "已结单");

		public Long key;
		public String value;

		private ChangeName(Long key, String value) {
			this.key = key;
			this.value = value;
		}

		public static String getValue(Long key) {
			if (key == null) {
				return null;
			} else {
				ChangeName[] var1 = values();
				int var2 = var1.length;

				for(int var3 = 0; var3 < var2; ++var3) {
					ChangeName changeNameStatus = var1[var3];
					if (changeNameStatus.key.equals(key)) {
						return changeNameStatus.value;
					}
				}

				return null;
			}
		}
	}

}
