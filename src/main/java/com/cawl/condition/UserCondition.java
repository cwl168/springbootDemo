package com.cawl.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;



public class UserCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //导入Jedis依赖，加载该bean,没有导入，则不加载
        // 思路：判断redis.clients.jedis.class 是否存在
        boolean flag = true;
        try {
            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
            System.out.println(cls);
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
