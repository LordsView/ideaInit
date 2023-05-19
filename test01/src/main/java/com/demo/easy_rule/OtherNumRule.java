package com.demo.easy_rule;

import org.jeasy.rules.annotation.*;

/**
 * 打印其余数字
 */
@Rule
public class OtherNumRule {

    @Condition
    public boolean isFiveSevenRule(@Fact("number") Integer number) {
        return true;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        System.out.println(number);
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}
