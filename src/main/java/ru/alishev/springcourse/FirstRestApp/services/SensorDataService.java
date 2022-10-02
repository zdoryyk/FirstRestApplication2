package ru.alishev.springcourse.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.FirstRestApp.dto.SensorDataDTO;
import ru.alishev.springcourse.FirstRestApp.models.SensorData;
import ru.alishev.springcourse.FirstRestApp.repositories.SensorDataRepository;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public void save(SensorData sensorData){
        sensorDataRepository.save(sensorData);
    }
}
