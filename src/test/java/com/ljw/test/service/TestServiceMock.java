package com.ljw.test.service;

import com.ljw.test.dao.UserRepository;
import com.ljw.test.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description: Mock 测试 Service 层
 * 1. Mock 机制就是使用 Mock 对象替代真实的依赖对象，并模拟真实场景来开展测试工作。
 * 2. @SpringBootTest 注解中的 SpringBootTest.WebEnvironment.MOCK 选项，该选项用于加载 WebApplicationContext 并提供一个 Mock 的 Servlet 环境，内置的 Servlet 容器并没有真实启动。
 * @Author: jianweil
 * @date: 2021/11/22 18:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TestServiceMock {
    /**
     * @MockBean使数据隔离
     */
    @MockBean
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    /**
     * 1. 首先，我们通过 @MockBean 注解注入了 userRepository；
     * 2. 然后，基于第三方 Mock 框架 Mockito 提供的 when/thenReturn 机制完成了对 userRepository 中 getById() 方法的 Mock。
     * 3. 当然，如果你希望在测试用例中直接注入真实的userRepository，这时就可以使用@SpringBootTest 注解中的 SpringBootTest.WebEnvironment.RANDOM_PORT 选项
     *
     * @throws Exception
     */
    @Test
    public void testGetById() throws Exception {
        Long id = 22L;
        //用Mock构建测试方法userService.findById(22L)需要的userRepository.getById(id)的数据，
        Mockito.when(userRepository.getById(id)).thenReturn(new User(22L, "MockBean", 22, "MockBean@qq.com"));
        User user = userService.findById(22L);
        Assert.assertNotNull(user);
        Assert.assertEquals("MockBean", user.getName());
    }
}
