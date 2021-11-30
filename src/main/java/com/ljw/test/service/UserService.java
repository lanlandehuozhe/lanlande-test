package com.ljw.test.service;

import com.ljw.test.dao.UserRepository;
import com.ljw.test.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: todo
 * @Author: jianweil
 * @date: 2021/11/22 19:02
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.getById(id);
    }
}
