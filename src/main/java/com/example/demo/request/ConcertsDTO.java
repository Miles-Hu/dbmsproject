package com.example.demo.request;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Miles
 * @create 2022-07-26 10:35 AM
 * @email miles.j.hoo@gmail.com
 **/
@Data
public class ConcertsDTO {

    private String title;

    private Integer concertType;

    private List<MusicWorkDTO> musicWorks;
}
