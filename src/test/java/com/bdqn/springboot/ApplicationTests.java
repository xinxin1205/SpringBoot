package com.bdqn.springboot;

import com.bdqn.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootTest
class ApplicationTests {

    @Autowired
    RedisUtil util;

    @Test
    void contextLoads() {
        System.out.println(util.get("User01"));
    }

}
