package com.demo.easy_rule;

import org.jeasy.rules.annotation.*;

/**
 * 当前数字能被5、7整除，打印能同时被5和7整除的数字
 */
@Rule
public class FiveSevenRule {


    @Condition
    public boolean isFiveSevenRule(@Fact("number") Integer number) {
        return number % 5 == 0 && number % 7 == 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        System.err.println("能同时被5和7整除的数字：" + number);
    }

    @Priority
    public int getPriority(){
        return 1;
    }

}
