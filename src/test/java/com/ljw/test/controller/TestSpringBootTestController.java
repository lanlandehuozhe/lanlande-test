package com.ljw.test.controller;

import com.ljw.test.entity.User;
import com.ljw.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Description: 测试控制器
 * 1. 在使用 @SpringBootTest 注解的场景下，如果我们想使用 MockMvc 对象，那么可以引入 @AutoConfigureMockMvc 注解。
 * 2. 通过将 @SpringBootTest 注解与 @AutoConfigureMockMvc 注解相结合，@AutoConfigureMockMvc 注解将通过 @SpringBootTest 加载的 Spring 上下文环境中自动配置 MockMvc 这个类。
 * 3. @SpringBootTest 注解不能和 @WebMvcTest 注解同时使用
 * @Author: jianweil
 * @date: 2021/11/22 19:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestSpringBootTestController {

    @Autowired
    private MockMvc mvc;

    /**
     * 模拟的
     */
    @MockBean
    private UserService userService;

    /**
     * MockMvc 类提供的基础方法分为以下 6 种：
     * Perform：执行一个 RequestBuilder 请求，会自动执行 SpringMVC 流程并映射到相应的 Controller 进行处理。
     * get/post/put/delete：声明发送一个 HTTP 请求的方式，根据 URI 模板和 URI 变量值得到一个 HTTP 请求，支持 GET、POST、PUT、DELETE 等 HTTP 方法。
     * param：添加请求参数，发送 JSON 数据时将不能使用这种方式，而应该采用 @ResponseBody 注解。
     * andExpect：添加 ResultMatcher 验证规则，通过对返回的数据进行判断来验证 Controller 执行结果是否正确。
     * andDo：添加 ResultHandler 结果处理器，比如调试时打印结果到控制台。
     * andReturn：最后返回相应的 MvcResult，然后执行自定义验证或做异步处理。
     *
     * @throws Exception
     */
    @Test
    public void testGetById() throws Exception {
        Long userId = 55L;
        //模拟实现
        given(this.userService.findById(userId))
                .willReturn(new User(55L, "MockBean", 55, "MockBean@qq.com"));
        this.mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/user/" + userId).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}

