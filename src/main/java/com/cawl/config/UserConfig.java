package com.cawl.config;

import com.cawl.condition.UserCondition;
import com.cawl.mybatis.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

//Condition的使用demo
@Configuration
public class UserConfig {
    @Bean
    @Conditional(UserCondition.class)
    public User user(){
        return new User();
    }
}
