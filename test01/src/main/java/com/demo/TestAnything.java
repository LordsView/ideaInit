package com.demo;

import com.alibaba.fastjson2.JSON;
import com.demo.dependency.SMSEntity;
import com.demo.dependency.SmsSendTemCode;
import com.demo.entity.Item;
import com.demo.enumtest.EventDomain;
import com.demo.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class TestAnything {

    @Test
    public void testArray() {
        int[] ints = new int[5];
        System.err.println(ints[1]);
    }

    @Test
    public void testSpilt() {
        String priceRegion = "12-20";
        double min = Double.parseDouble(priceRegion.split("-")[0]);
        double max = Double.parseDouble(priceRegion.split("-")[1]);
        System.err.println(min);
        System.err.println(max);
    }

    //wiwj-rap-rcd校验状态
    @Test
    public void checkState() {
        int i = 30;

        if (!((i > 0 && i < 16) || i == 30)) {
            System.err.println("条件成立");
        } else {
            System.err.println("条件不成立");
        }
    }

    @Test
    public void printStr() {
        String sql = "   with recursive cte as  " + "(  "
                + "select 1 level, d.ID id, d.CODE code, d.PARENT_ID parentId, d.IS_DEFAULT isDefault, "
                + "d.ORDERBY orderby, d.CREATE_DATE createDate, d.CREATE_BY createBy, d.UPDATE_DATE updateDate, "
                + "d.UPDATE_BY updateBy, d.VERSION version, d.IS_DELETED isDeleted, d.TYPE type, "
                + "d.AVAILABLE available, d.NAME name,d.DESCR descr,d.comp_id comp_id from sys_dict d "
                + "where d.is_deleted = '0' and  type= ? and code = ? " + "union all  "
                + "select c.level+1 level, k.ID id, k.CODE code, k.PARENT_ID parentId, k.IS_DEFAULT isDefault, "
                + "k.ORDERBY orderby, k.CREATE_DATE createDate, k.CREATE_BY createBy, k.UPDATE_DATE updateDate, "
                + "k.UPDATE_BY updateBy, k.VERSION version, k.IS_DELETED isDeleted, k.TYPE type, "
                + "k.AVAILABLE available, k.NAME name,k.DESCR descr,k.comp_id comp_id "
                + "from sys_dict k inner join cte c on c.id = k.PARENT_ID  and k.is_deleted='0' and k.is_deleted='0' and k.available ='1' "
                + ")select * from cte t ";
        System.err.println(sql);
    }

    @Test
    public void mill() {
//        long a = new Date().getTime();
        long b = System.currentTimeMillis();
//        System.err.println(a);
        System.err.println(b);
    }

    /**
     * BOOKED("10016003", "定金"),
     * SIGNED("10016004", "签约"),
     */
    @Test
    public void judge() {
        String state = "0";
        int day = 9;
        if (!("10016003".equals(state)
                && "10016004".equals(state)) || day < 0) {
            System.err.println(-1);
        } else {
            System.err.println(0);
        }
    }

    @Test
    public void generateUUID() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        /*
         * 20220601
         * ee0b23811b0c4dac884204cec7e2fe2a
         * 0c3b55a639144f07ae2f15db44ccbbdc
         */
        System.err.println(replaceAll);
    }

    @Test
    public void printSql() {
        StringBuffer sql = new StringBuffer(
                "select uoj.id id,uoj.user_id userId,u.username,u.real_name realName");
        sql.append(
                "      ,uoj.org_id orgId,o.org_name orgName,uoj.job_id jobId, j.job_code jobCode, j.job_name jobName,");
        sql.append(
                "      uoj.ismain, uoj.admin_org adminOrg,o.org_code orgCode,uoj.is_leader isLeader ");
        sql.append("         from uam.sys_user_org_job uoj,uam.sys_org o,uam.sys_job j,uam.sys_user u ");
        sql.append("        where   uoj.user_Id = 12000000099676 and j.job_Code = 'JDZZZ' ");
        sql.append("        and uoj.org_Id=o.id and uoj.job_Id=j.id and uoj.user_Id = u.id ");
        sql.append("        and j.is_Deleted = '0' and uoj.is_Deleted = '0'");

        System.err.println(sql.toString());
    }

    @Test
    public void testSubString() {
        String agentRecordNum = "ZL016437";
        System.err.println(agentRecordNum.substring(0, 2));
        System.err.println(agentRecordNum.substring(1));
    }

    @Test
    public void testSbString() {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ifnull(value,default_value) param from sys_param_define d ,");
//        sql.append("    sys_param_value  v,sys_app a ");
        sql.append("    sys_param_value  v ");
        sql.append("    where v.DEF_ID = d.ID ");
//        sql.append("    and a.id = d.app_id ");
//        sql.append("    and a.app_name= ? ");
        sql.append("    and MODULE = ? ");
        sql.append("    and CODE = ? ");

//        sql.append("    and v.comp_Id = ? ");
        sql.append("    and d.is_VALID = '1' ");
        sql.append("    and d.IS_DELETED = '0' ");
        sql.append("    and v.IS_DELETED = '0'");
        sql.append("    limit 1 ");
        sql = new StringBuffer();
        sql.append("with recursive cte as  ");
        sql.append("(  ");
        sql.append("    select a.id ,a.org_name,a.parent_id,1 level from sys_org a where  a.id= ? ");
        sql.append("    union all   ");
        sql.append("    select k.id , k.org_name, k.parent_id,c.level+1 from sys_org k inner join cte c on c.PARENT_ID = k.id  where ");
        sql.append("    k.is_deleted='0' and k.available='1' ");
        sql.append(") select ifnull(v.value,default_value) param from sys_param_define d , ");
//            sql.append("    sys_param_value  v,sys_app a ,cte c ");
        sql.append("    sys_param_value  v,cte c ");
        sql.append("  where v.DEF_ID = d.ID ");
        //如果是全局,只根据公司查询,非全局可以设置到组织
        sql.append("    and c.id = v.org_id ");

//            sql.append("    and a.id = d.app_id ");
//            sql.append("    and a.app_name= ? ");
        sql.append("    and v.comp_Id = ? ");
        sql.append("    and MODULE = ? ");

        sql.append("    and CODE = ? ");
        sql.append("    and d.is_VALID = '1' ");
        sql.append("    and d.IS_DELETED = '0' ");
        sql.append("    and v.IS_DELETED = '0'");
        sql.append("    order by c.level asc ");
        sql.append("    limit 1 ");
        System.err.println(sql.toString());
    }

    @Test
    public void testConvertStringToInteger() {
        String employeeCode = "17602919807"; // 超长
        int parseInt = Integer.parseInt(employeeCode);
        System.err.println(parseInt);

    }

    @Test
    public void testMD5() {
        String tokenStr = "WIWJSMSPushReply";//1ef96bc7c53d7c5d2afbe857f5ca3443
        System.err.println(Md5Util.md51(tokenStr));
        System.err.println(Md5Util.hash(tokenStr));
    }

    @Test
    public void testLong(){
        Long a = 10L;
        Long b = 6L;
    }

    @Test
    public void testMap(){
        List<String> list = new ArrayList<>();
        list.add("13000000000");
        Map<String, Object> messageParams = new HashMap<>();
        messageParams.put("price","100");
        sendMsgByTemplateCode(list,"SALES",messageParams);
    }
    //
    public void sendMsgByTemplateCode(List<String> phoneList, String templateCode, Map<String, Object> messageParams) {
            try{
                for (int i = 0; i < phoneList.size(); i++) {
                    SMSEntity smsEntity = new SMSEntity();
                    smsEntity.setPhone(phoneList.get(i));
                    smsEntity.setTemplateId(templateCode);
                    smsEntity.setSignature("爱家加盟");
                    if(SmsSendTemCode.SALES.getCode().equals(templateCode)||SmsSendTemCode.RENT.getCode().equals(templateCode)||SmsSendTemCode.SALESRENT.getCode().equals(templateCode)){
                        if (StringUtils.isBlank((String) messageParams.get("activator"))) {
                            messageParams.put("activator","none");
                        }
                        if (StringUtils.isBlank((String) messageParams.get("activatorPhone"))) {
                            messageParams.put("activatorPhone","none");
                        }
                    }
                    smsEntity.setParams(messageParams);
                    smsEntity.setCompid("1");
                    System.err.println(JSON.toJSONString(smsEntity));
                }

            }catch (Exception e){
                System.out.println("send sms failed");
                e.printStackTrace();
            }
    }

    @Test
    public void testString(){
        StringBuffer sbsql=new StringBuffer();

        sbsql.append("select pri.HOUSE_ID ").append("val")
                .append(", pri.HOUSE_ID ")
                .append(",count(*) cnt from T_HM_PropertyRight pri ")
                .append("INNER JOIN T_HM_OWNER own ON own.PR_ID=pri.pkid AND own.STATUS=1 WHERE pri.HOUSE_ID in(:houseid) AND pri.IS_LATEST=1 ")
                .append("group by pri.HOUSE_ID");

        System.err.println(sbsql.toString());
    }

    @Test
    public void testExpressionParser(){
        String expStr="portal_push.official.queryAllValidRuleItem";
        Object[] argvs = {0};
        String[] strings = {"value"};
        String code = getCode(expStr, argvs, strings);
        System.err.println(code);
    }

    @Test
    public void testExpressionParser2(){
        ExpressionParser parser = new SpelExpressionParser();

        //literal expressions
        Expression exp = parser.parseExpression("'Hello World'");
        String msg1 = exp.getValue(String.class);
        System.out.println(msg1);

        //method invocation
        Expression exp2 = parser.parseExpression("'Hello World'.length()");
        int msg2 = (Integer) exp2.getValue();
        System.out.println(msg2);

        //Mathematical operators
        Expression exp3 = parser.parseExpression("100 * 2");
        int msg3 = (Integer) exp3.getValue();
        System.out.println(msg3);

        //create an item object
        Item item = new Item("yiibai", 100);
        //test EL with item object
        StandardEvaluationContext itemContext = new StandardEvaluationContext(item);

        //display the value of item.name property
        Expression exp4 = parser.parseExpression("name");
        String msg4 = exp4.getValue(itemContext, String.class);
        System.out.println(msg4);

        //test if item.name == 'yiibai'
        Expression exp5 = parser.parseExpression("name == 'yiibai'");
        boolean msg5 = exp5.getValue(itemContext, Boolean.class);
        System.out.println(msg5);

    }

    private String getCode(String expressionString, Object[] argus, String[] argusNames) {
        if (null == argusNames) {
            return null;
        }
        ExpressionParser parser= new SpelExpressionParser();
        Expression exp=parser.parseExpression(expressionString);
        EvaluationContext context= new StandardEvaluationContext();

        for (int i = 0; i < argusNames.length; i++) {
            String arguName = argusNames[i];
            Object arguValue = argus[i];
            context.setVariable(arguName, arguValue);
        }
        String code = exp.getValue(context, String.class);
        return code;
    }

    @Test
    public void testEnum(){
        System.err.println(EventDomain.HOUSE.name());
    }

    // final修饰的字符串会在编译期放入常量池
//    private final  String A = "a";// true true true
    private String A = "a"; // true false false
    @Test
    public void testStrEquals(){

        String s = "a"+"b";//两个字符串常量拼接
        String s1 = "ab";
        String s2 = A+"b";//常量引用和字符串常量拼接
        String s3 = s2.intern();
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s2 == s1);
        System.out.println(s3 == s1);
    }

}
