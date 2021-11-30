package com.ljw.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 1. @SpringBootTest 注解提供的默认功能对作为 Bootstrap 类的 Application 类进行测试。
 * @Author: jianweil
 * @date: 2021/11/22 17:48
 */
//1.
@SpringBootTest
//2. 指定启动类和启动环境
/*
MOCK：加载 WebApplicationContext 并提供一个 Mock 的 Servlet 环境，此时内置的 Servlet 容器并没有正式启动。
RANDOM_PORT：加载 EmbeddedWebApplicationContext 并提供一个真实的 Servlet 环境，然后使用一个随机端口启动内置容器。
DEFINED_PORT：这个配置也是通过加载 EmbeddedWebApplicationContext 提供一个真实的 Servlet 环境，但使用的是默认端口，如果没有配置端口就使用 8080。
NONE：加载 ApplicationContext 但并不提供任何真实的 Servlet 环境。
在 Spring Boot 中，@SpringBootTest 注解主要用于测试基于自动配置的 ApplicationContext，它允许我们设置测试上下文中的 Servlet 环境。class
*/
//@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)

/*
JUnit 框架提供的 @RunWith 注解，它用于设置测试运行器。例如，我们可以通过 @RunWith(SpringJUnit4ClassRunner.class) 让测试运行于 Spring 测试环境。
虽然这我们指定的是 SpringRunner.class，实际上，SpringRunner 就是 SpringJUnit4ClassRunner 的简化，它允许 JUnit 和 Spring TestContext 整合运行，而 Spring TestContext 则提供了用于测试 Spring 应用程序的各项通用的支持功能。
*/
@RunWith(SpringRunner.class)
public class TestApplicationContext {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testContextLoads() throws Throwable {
        Assert.assertNotNull(this.applicationContext);
    }
}
