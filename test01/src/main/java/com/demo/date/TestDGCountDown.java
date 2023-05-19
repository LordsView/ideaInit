package com.demo.date;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: workspace-IDEAInit
 * @description: 掉公倒计时时间
 * @author: lzz
 * @create: 2022-04-21 11:06
 */
public class TestDGCountDown {

    private static final Integer ONE_DAY = 24*60*60*1000;

    public static void main(String[] args) {
        Long format = getLastDateFormat("15", "2022/01/21");
        System.err.println(format);
    }

    private static Long getLastDateFormat(String pool, String trackTime){

        if(StringUtils.isBlank(trackTime)){
            return Long.parseLong(pool);
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Long time = (Long.parseLong(pool)+1)*ONE_DAY - (new Date().getTime() - sdf.parse(trackTime).getTime());
                if(time >0){
                    return time/ONE_DAY;
                }
            } catch (ParseException e) {
            }
        }
        return 0L;
    }
}
