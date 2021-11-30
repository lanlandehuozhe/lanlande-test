package com.ljw.test.dao;

import com.ljw.test.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 1. @DataJpaTest 注解会自动注入各种 Repository 类，并初始化一个内存数据库和及访问该数据库的数据源。
 * 2. 在测试场景下，情况下，用@DataJpaTest 注解的测试使用嵌入式内存数据库。我们可以使用 H2 作为内存数据库，并通过 MySQL 实现数据持久化
 * 3. 它与@RunWith（SpringRunner.class）结合使用。 注解会禁用完全自动配置，并且仅应用与 JPA 测试相关的配置。
 * @Author: jianweil
 * @date: 2021/11/22 17:46
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestDao {

    /**
     * 效果相当于不使用真正的 UserRepository 完成数据的持久化，从而提供了一种数据与环境之间的隔离机制。
     */
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    /**
     * @throws Exception
     */
    @Test
    public void testFindCustomerTicketById() throws Exception {
        String expected = "new6@qq.com";
        User user1 = new User();
        user1.setName("new6");
        user1.setAge(6);
        user1.setEmail(expected);
        //User user3 = this.userRepository.save(user1);
        //User的id自增策略 IDENTITY策略：用初始化好数据的h2数据库保存 id=6
        //User的id自增策略 SEQUENCE策略：使用新的空的h2数据库保存 id=1
        //与上面效果一样
        this.entityManager.persist(user1);

        User user2 = new User();
        user2.setName("new7");
        user2.setAge(7);
        user2.setEmail("new7@qq.com");
        //User user4 = this.userRepository.save(user2);
        this.entityManager.persist(user2);

        User user6 = this.userRepository.getById(6L);
        User user7 = this.userRepository.getById(7L);

        Assert.assertNotNull(user6);
        Assert.assertEquals(expected, user6.getEmail());

        Assert.assertEquals("new7@qq.com", user7.getEmail());
    }

}
