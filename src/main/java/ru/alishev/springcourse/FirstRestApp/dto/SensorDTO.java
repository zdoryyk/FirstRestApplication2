package ru.alishev.springcourse.FirstRestApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class SensorDTO {

    @NotEmpty(message = "type smthg")
    @Min(value = 2,message = "Min 2")
    @Max(value = 30,message = "Max 30")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
