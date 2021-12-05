package com.cawl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//SpringBootTest 不用增加 classes = DemoApplication.class 因为是同一层级的包
@SpringBootTest
class UserServiceTests1 {
    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceAdd1() {
        System.out.println(userService);
        userService.testAdd();
    }

}
