package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Miles
 * @create 2022-07-23 3:55 PM
 * @email miles.j.hoo@gmail.com
 **/

@Data
@Table
@Entity
public class Musician {

    /**
     * 用户编号
     */
    @Id // 表示该字段为主键 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC") // strategy 设置使用数据库主键自增策略；generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer musicianId;

    private String Fname;

    private String Minit;

    private String Lname;

}
