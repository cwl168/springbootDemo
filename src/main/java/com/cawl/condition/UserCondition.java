package com.cawl.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;



public class UserCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //条件：若导入Jedis坐标后，则加载该bean,若没有导入，则不加载
        // 思路：判断redis.clients.jedis.class 是否存在
        //return false;
        boolean flag = true;
        try {
            //没有导入jedis坐标，则没有加载到Jedis字节码，会抛异常
            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
            System.out.println("matches:"+cls);
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
