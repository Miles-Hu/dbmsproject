package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Miles
 * @create 2022-07-25 10:42 AM
 * @email miles.j.hoo@gmail.com
 **/

@Entity
@Table
@Data
public class Instruments {

    @Id
    private String name;

}
