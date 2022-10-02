package ru.alishev.springcourse.FirstRestApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class SensorDTO {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
