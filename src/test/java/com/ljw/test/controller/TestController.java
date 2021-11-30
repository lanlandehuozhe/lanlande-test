package com.ljw.test.controller;

import com.ljw.test.entity.User;
import com.ljw.test.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

/**
 * @Description: 测试控制器
 * 1. 如果我们想在测试环境中使用 @SpringBootTest，则可以直接使用 TestRestTemplate 来测试远程访问过程
 * 2. Spring Boot 提供的 TestRestTemplate 与 RestTemplate 非常类似，只不过它专门用在测试环境中。
 * @Author: jianweil
 * @date: 2021/11/22 19:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserService userService;

    /**
     * @throws Exception
     * @SpringBootTest 注解通过使用 SpringBootTest.WebEnvironment.RANDOM_PORT 指定了随机端口的 Web 运行环境。
     * 然后，我们基于 TestRestTemplate 发起了 HTTP 请求并验证了结果。
     */
    @Test
    public void testGenerateCustomerTicket() throws Exception {
        Long userId = 1L;
        given(this.userService.findById(userId))
                .willReturn(new User(1L, "MockBean", 44, "MockBean@qq.com"));
        //postForObject是post请求
        ResponseEntity<User> responseEntity = testRestTemplate.exchange("/user/" + userId, HttpMethod.GET, null, User.class);
        Assert.assertEquals("MockBean@qq.com", responseEntity.getBody().getEmail());
    }
}

