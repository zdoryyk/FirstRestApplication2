package ru.alishev.springcourse.FirstRestApp.dto;

import ru.alishev.springcourse.FirstRestApp.models.Sensor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MeasurementsDTO {

    private Integer id;

    @Column(name = "value")
    private Float value;

    @Column(name = "raining")
    private Boolean raining;

    @ManyToOne()
    @JoinColumn(name = "id",referencedColumnName = "sensor_id")
    private Sensor sensor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
