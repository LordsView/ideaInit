package com.demo.cbs;

import java.util.*;
import java.util.stream.Collectors;

public class ParamCheckTest {

    public static void main(String[] args) {

        List<SignIntentionUsersVo> tradeUsers = new ArrayList<>();

        SignIntentionUsersVo user1 = new SignIntentionUsersVo();
        List<IntentionPhonesVo> phoneList1 = new ArrayList<>();
        user1.setProxyType(1L);
        user1.setFullname("张三");
        user1.setIdcardNo("111");
        IntentionPhonesVo phone11 = new IntentionPhonesVo();
        IntentionPhonesVo phone12 = new IntentionPhonesVo();
        phone11.setPhoneNumber("11000000000");
        phone12.setPhoneNumber("12000000000");
        phoneList1.add(phone11);
        phoneList1.add(phone12);
        user1.setUserPhone(phoneList1);

        SignIntentionUsersVo user2 = new SignIntentionUsersVo();
        List<IntentionPhonesVo> phoneList2 = new ArrayList<>();
        user2.setProxyType(2L);
        user2.setFullname("张四");
        user2.setIdcardNo("222");
        IntentionPhonesVo phone21 = new IntentionPhonesVo();
        IntentionPhonesVo phone22 = new IntentionPhonesVo();
        phone21.setPhoneNumber("13000000000");
        phone22.setPhoneNumber("14000000000");
        phoneList2.add(phone21);
        phoneList2.add(phone22);
        user2.setUserPhone(phoneList2);

        SignIntentionUsersVo user3 = new SignIntentionUsersVo();
        List<IntentionPhonesVo> phoneList3 = new ArrayList<>();
        user3.setProxyType(4L);
        user3.setFullname("王五");
        user3.setIdcardNo("333");
        IntentionPhonesVo phone31 = new IntentionPhonesVo();
        IntentionPhonesVo phone32 = new IntentionPhonesVo();
        phone31.setPhoneNumber("15000000000");
        phone32.setPhoneNumber("16000000000");
        phoneList3.add(phone31);
        phoneList3.add(phone32);
        user3.setUserPhone(phoneList3);

        SignIntentionUsersVo user4 = new SignIntentionUsersVo();
        List<IntentionPhonesVo> phoneList4 = new ArrayList<>();
        user4.setProxyType(5L);
        user4.setFullname("王六");
        user4.setIdcardNo("444");
        IntentionPhonesVo phone41 = new IntentionPhonesVo();
        IntentionPhonesVo phone42 = new IntentionPhonesVo();
        phone41.setPhoneNumber("17000000000");
        phone42.setPhoneNumber("18000000000");
        phoneList4.add(phone41);
        phoneList4.add(phone42);
        user4.setUserPhone(phoneList4);

        tradeUsers.add(user1);
        tradeUsers.add(user2);
        tradeUsers.add(user3);
        tradeUsers.add(user4);

        System.err.println(tradeUserTest(tradeUsers));
    }

    private static String tradeUserTest(List<SignIntentionUsersVo> tradeUsers){
        if(tradeUsers !=null && !tradeUsers.isEmpty()){
            //身份证校验
            List<SignIntentionUsersVo> usersVos = tradeUsers.stream().filter(
                    x -> x.getProxyType() == Long.parseLong(SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeOne.key)
                            ||x.getProxyType() == Long.parseLong(SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeTwo.key)
                            ||x.getProxyType() == Long.parseLong(SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeFour.key)
                            ||x.getProxyType() == Long.parseLong(SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeFive.key)).collect(Collectors.toList());
            List<SignIntentionUsersVo> usersVosTrim = usersVos.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SignIntentionUsersVo::getIdcardNo))), ArrayList::new));

            if(usersVosTrim.size() < usersVos.size()){
                return getIdPhoneCheckMsg(usersVos);
            }
            //手机号校验
            List<String> usersOwnerPhones = getPhoneList(tradeUsers,
                    SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeOne.key,
                    SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeTwo.key);

            List<String> usersCustomerPhones = getPhoneList(tradeUsers,
                    SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeFour.key,
                    SignSalesContractTypeEnum.ProxyUserType.ProxyUserTypeFive.key);

            boolean phoneFlag = true;
            for(String str : usersCustomerPhones){
                if(usersOwnerPhones.contains(str)){
                    phoneFlag=false;
                    break;
                }
            }
            if(!phoneFlag){
                return getIdPhoneCheckMsg(usersVos);
            }

        }
        return  null;
    }

    private static List<String> getPhoneList(List<SignIntentionUsersVo> tradeUsers,String typeOne,String typeTwo){
        return tradeUsers.stream().filter(x -> x.getProxyType() == Long.parseLong(typeOne)||x.getProxyType() == Long.parseLong(typeTwo))
                .map(SignIntentionUsersVo::getUserPhone)
                .flatMap(Collection::stream)
                .map(IntentionPhonesVo::getPhoneNumber)
                .collect(Collectors.toList());
    }

    private static String getIdPhoneCheckMsg(List<SignIntentionUsersVo> usersVos){
        //“甲方-XX、乙方-XX的身份证件号码或手机号一致，请检查！
        StringBuilder sb = new StringBuilder();
        for(SignIntentionUsersVo vo :usersVos){
            sb.append("、").append(SignSalesContractTypeEnum.ProxyUserTypeAlias.getValue(vo.getProxyType() + "")).append("-").append(vo.getFullname());
        }
        sb.append("的身份证件号码或手机号一致，请检查！");
        return sb.substring(1);
    }
}
