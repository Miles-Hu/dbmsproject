package com.example.demo.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-26 10:37 AM
 * @email miles.j.hoo@gmail.com
 **/


@Data
public class FeaturedID implements Serializable {

    private String concertTitle;

    private String musicTitle;
}
