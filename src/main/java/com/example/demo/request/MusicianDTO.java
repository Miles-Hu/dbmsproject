package com.example.demo.request;

import com.example.demo.models.Instruments;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * @author Miles
 * @create 2022-07-25 10:54 AM
 * @email miles.j.hoo@gmail.com
 **/

@Data
public class MusicianDTO {

    private Integer musicianId;

    @JsonProperty(value = "Fname")
    private String Fname;

    @JsonProperty(value = "Minit")
    private String Minit;

    @JsonProperty(value = "Lname")
    private String Lname;

    @JsonProperty(value = "Instruments")
    private List<Instruments> Instruments;

}
