package com.test2;

import com.cawl.DemoApplication;
import com.cawl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class )
//@SpringBootTest 该注解会提示错误
class UserServiceTests3 {
    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceAdd3() {
        System.out.println(userService);
        userService.testAdd();
    }

}
