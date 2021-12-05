package com.cawl.test;

import com.cawl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//SpringBootTest 不用增加 classes = DemoApplication.class 因为是子包
@SpringBootTest
class UserServiceTest2 {
    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceAdd2() {
        System.out.println(userService);
        userService.testAdd();
    }

}
