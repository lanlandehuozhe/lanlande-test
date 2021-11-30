package com.ljw.test.dao;

import com.ljw.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: todo
 * @Author: jianweil
 * @date: 2021/11/22 17:29
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
