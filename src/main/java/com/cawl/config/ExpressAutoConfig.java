package com.cawl.config;

import com.cawl.condition.ExpressFalseBean;
import com.cawl.condition.ExpressTrueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration标注在类上，相当于把该类作为spring的xml配置文件中的 <bean>，作用为：配置spring容器(应用上下文)
//用@Configuration注解该类，等价 与XML中配置beans；用@Bean标注方法等价于XML中配置bean。
@Configuration
public class ExpressAutoConfig {
    @Autowired
    private Environment environment;
    /**
     * 当存在配置，且配置为true时才创建这个bean
     * @return
     */
    @Bean
    @ConditionalOnExpression("#{'true'.equals(environment.getProperty('conditional.express'))}")
    public ExpressTrueBean expressTrueBean() {
        System.out.println("expressTrueBean:"+environment.getProperty("conditional.express"));
        return new ExpressTrueBean("express true");
    }

    /**
     * 配置不存在，或配置的值不是true时，才创建bean
     * @return
     */
    @Bean
    @ConditionalOnExpression("#{!'true'.equals(environment.getProperty('conditional.express'))}")
    public ExpressFalseBean expressFalseBean() {
        System.out.println("expressFalseBean:"+environment.getProperty("conditional.express"));
        return new ExpressFalseBean("express != true");
    }
}
