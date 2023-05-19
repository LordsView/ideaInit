package com.demo.easy_rule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;

public class FizzBuzzWithEasyRules {

    /**
     * Easy Rules引擎可以配置以下参数:
     * <p>
     * rulePriorityThreshold：当优先级超过指定的阈值时，跳过余下的规则。
     * skipOnFirstAppliedRule：当一个规则成功应用时，跳过余下的规则。
     * skipOnFirstFailedRule：当一个规则失败时，跳过余下的规则。
     * skipOnFirstNonTriggeredRule：当一个规则未触发时，跳过余下的规则。
     *
     * @param args
     */
    public static void main(String[] args) {
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        DefaultRulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        Rules rules = new Rules();
        rules.register(new FiveSevenRule());
        rules.register(new OtherNumRule());

        Facts facts = new Facts();
        for (int i = 0; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
        }
//        System.err.println(facts.asMap().values());
    }
}
