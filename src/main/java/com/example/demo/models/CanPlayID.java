package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Miles
 * @create 2022-07-25 10:48 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class CanPlayID implements Serializable {

    private Integer musicianId;

    private String instrumentName;

}
