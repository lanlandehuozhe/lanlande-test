package com.ljw.test.noMock;

import com.ljw.test.dao.UserRepository;
import com.ljw.test.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

//去除mysql链接配置，走h2.如果配置了msql，走真实数据库
@SpringBootTest
class TestApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    @Transactional
    void contextLoads() {
        //要在配置文件配置初始化数据，去H2查
        User u = repository.getById(1L);
        Assert.assertEquals("成功的测试用例", "Jone", u.getName());
    }
}
