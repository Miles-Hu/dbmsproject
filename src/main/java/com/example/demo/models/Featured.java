package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-26 10:37 AM
 * @email miles.j.hoo@gmail.com
 **/


@Data
@Table
@Entity
@IdClass(FeaturedID.class)
public class Featured {

    @Id
    private String concertTitle;

    @Id
    private String musicTitle;
}
