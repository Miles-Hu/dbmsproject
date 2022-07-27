package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String title;

    private Date datetime;

    private String place;

    private String concertTitle;

}
