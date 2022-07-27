package com.example.demo.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-26 10:01 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class ComposedOfID implements Serializable {

    private String musicTitle;

    private String instrumentName;

}
