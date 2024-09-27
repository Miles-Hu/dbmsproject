package com.example.demo.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-26 10:03 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class PlaysInID implements Serializable {

    private Integer musicianId;

    private String musicTitle;

}
