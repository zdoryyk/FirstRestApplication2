package ru.alishev.springcourse.FirstRestApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sensor_name")
    @NotEmpty
    @Min(value = 2)
    @Max(value = 30)
    private String sensorName;

    @OneToMany(mappedBy = "sensor",fetch = FetchType.EAGER)
    private List<SensorData> dataList;


    public Sensor() {
    }

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String name) {
        this.sensorName = name;
    }

    public List<SensorData> getDataList() {
        return dataList;
    }

    public void setDataList(List<SensorData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", sensorName='" + sensorName + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}
