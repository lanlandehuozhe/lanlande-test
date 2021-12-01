package com.ljw.test.service;

import com.ljw.test.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @Description: Mock 测试 Service 层
 * 1. SpringBootTest.WebEnvironment.RANDOM_PORT：以一个随机的端口启动整个 Spring Boot 工程，并从数据库中真实获取目标数据进行验证。
 * @Author: jianweil
 * @date: 2021/11/22 18:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestServiceNoMock {

    @Resource
    private UserService userService;

    /**
     * 报错没有seesion是jpa框架导致，解决有：
     * 1. 加事务注解  @Transactional
     * 2. 实体类加@Proxy(lazy = false)
     * 3. 配置文件加spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testGetById() throws Exception {
        Long id = 1L;
        User user = userService.findById(id);
        Assert.assertNotNull(user);
        Assert.assertEquals("Jone", user.getName());
    }
}
