package com.example.demo.request;

import lombok.Data;

import java.util.Date;

/**
 * @author Miles
 * @create 2022-07-26 2:54 PM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class EventsDTO {

    private Integer eventId;

    private String title;

    private long datetime;

    private String place;

    private String concertTitle;

}
