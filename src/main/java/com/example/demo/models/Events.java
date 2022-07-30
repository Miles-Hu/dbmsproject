package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Miles
 * @create 2022-07-26 2:42 PM
 * @email miles.j.hoo@gmail.com
 **/

@Data
@Table
@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC") // strategy 设置使用数据库主键自增策略；generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer eventId;

    private String title;

    private Date datetime;

    private String place;

    private String concertTitle;

}
