package com.example.demo.request;

import com.example.demo.models.Instruments;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Miles
 * @create 2022-07-26 9:56 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class MusicWorkDTO {

    private String title;

    private Integer musicType;

    @JsonProperty(value = "Instruments")
    private List<Instruments> Instruments;

    private List<MusicianDTO> musicians;

}
