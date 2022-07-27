package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Miles
 * @create 2022-07-25 10:48 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
@Table
@Entity
@IdClass(CanPlayID.class)
public class CanPlay {

    @Id
    private Integer musicianId;

    @Id
    private String instrumentName;

}
