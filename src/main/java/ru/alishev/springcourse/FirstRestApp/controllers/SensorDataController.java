package ru.alishev.springcourse.FirstRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.alishev.springcourse.FirstRestApp.dto.SensorDTO;
import ru.alishev.springcourse.FirstRestApp.dto.SensorDataDTO;
import ru.alishev.springcourse.FirstRestApp.models.Sensor;
import ru.alishev.springcourse.FirstRestApp.models.SensorData;
import ru.alishev.springcourse.FirstRestApp.repositories.SensorDataRepository;

@Controller
public class SensorDataController {

    private final SensorDataRepository sensorDataRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SensorDataController(SensorDataRepository sensorDataRepository, ModelMapper modelMapper) {
        this.sensorDataRepository = sensorDataRepository;
        this.modelMapper = modelMapper;
    }

    public SensorData convertToSensorData(SensorDataDTO sensorDataDTO){
        return modelMapper.map(sensorDataDTO,SensorData.class);
    }

    public SensorDataDTO convertToSensorDTO(SensorData sensorData){
        return modelMapper.map(sensorData,SensorDataDTO.class);
    }
}
