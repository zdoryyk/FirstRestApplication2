package ru.alishev.springcourse.FirstRestApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull
    @Column(name = "value")
    @Min(value = -100)
    @Max(value = 100)
    private int value;

    @Column(name = "raining")
    private boolean raining;


    public SensorData(int value, boolean raining) {
        this.value = value;
        this.raining = raining;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name",referencedColumnName = "sensor_name")
    private Sensor sensor;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public SensorData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
