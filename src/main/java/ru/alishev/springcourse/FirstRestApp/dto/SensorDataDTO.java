package ru.alishev.springcourse.FirstRestApp.dto;

import ru.alishev.springcourse.FirstRestApp.models.Sensor;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SensorDataDTO {


    @NotNull
    @Min(value = -100)
    @Max(value = 100)
    private int value;

    private boolean raining;


    private SensorDTO sensorDTO;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensorDTO() {
        return sensorDTO;
    }

    public void setSensorDTO(SensorDTO sensorDTO) {
        this.sensorDTO = sensorDTO;
    }
}
