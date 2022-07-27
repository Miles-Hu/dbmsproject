package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Miles
 * @create 2022-07-26 10:35 AM
 * @email miles.j.hoo@gmail.com
 **/
@Data
@Table
@Entity
public class Concerts {

    @Id
    private String title;

    private Integer concertType;

}
