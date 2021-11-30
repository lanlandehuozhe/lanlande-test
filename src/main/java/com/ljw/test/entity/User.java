package com.ljw.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Description: todo
 * GenerationType:
 * TABLE：使用一个特定的数据库表格来保存主键。
 * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
 * IDENTITY：主键由数据库自动生成（主要是自动增长型）
 * AUTO：主键由程序控制选择上面的一个策略。
 * @Author: jianweil
 * @date: 2021/11/22 17:29
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Proxy(lazy = false)
public class User {
    @Id
    //配置了h2GenerationType.AUTO程序帮助我们使用了GenerationType.SEQUENCE
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //序列化
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    // https://www.cnblogs.com/hongchengshise/p/10612301.html
    //数据库自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String email;
}
