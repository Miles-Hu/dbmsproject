package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-26 10:03 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
@Table
@Entity
@IdClass(PlaysInID.class)
public class PlaysIn{

    @Id
    private Integer musicianId;

    @Id
    private String musicTitle;

}
