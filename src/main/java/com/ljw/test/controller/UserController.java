package com.ljw.test.controller;

import com.ljw.test.entity.User;
import com.ljw.test.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: todo
 * @Author: jianweil
 * @date: 2021/11/22 17:28
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
