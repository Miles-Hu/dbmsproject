package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Miles
 * @create 2022-07-26 10:00 AM
 * @email miles.j.hoo@gmail.com
 **/

@Entity
@Table
@Data
@IdClass(ComposedOfID.class)
public class ComposedOf {

    @Id
    private String musicTitle;

    @Id
    private String instrumentName;

}
