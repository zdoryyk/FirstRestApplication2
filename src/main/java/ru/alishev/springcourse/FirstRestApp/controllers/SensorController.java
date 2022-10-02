package ru.alishev.springcourse.FirstRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.alishev.springcourse.FirstRestApp.dto.SensorDTO;
import ru.alishev.springcourse.FirstRestApp.dto.SensorDataDTO;
import ru.alishev.springcourse.FirstRestApp.models.Sensor;
import ru.alishev.springcourse.FirstRestApp.models.SensorData;
import ru.alishev.springcourse.FirstRestApp.services.SensorService;
import ru.alishev.springcourse.FirstRestApp.util.SensorNotCreatedException;

import java.util.List;

@Controller
public class SensorController {

    private final SensorService sensorService;

    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/sensors/registration")
    public ResponseEntity<HttpStatus> createSensor(@RequestBody SensorDTO sensor,
                                             BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors){
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new SensorNotCreatedException(errorMsg.toString());
        }
        sensorService.save(convertToSensor(sensor));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/measurements/add")
    public ResponseEntity<HttpStatus> addDataService(@RequestBody SensorDataDTO sensorDataDTO,
                                                     BindingResult bindingResult){

        System.out.println("DATAAAAAAAA- " + sensorDataDTO.getValue());
        System.out.println("DATAAAAAAAA- " + sensorDataDTO.isRaining());
        System.out.println(sensorDataDTO.getSensorDTO().getName());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public Sensor convertToSensor(SensorDTO sensorDTO){
        return modelMapper.map(sensorDTO,Sensor.class);
    }

    public SensorDTO convertToSensorDTO(Sensor sensor){
        return modelMapper.map(sensor,SensorDTO.class);
    }

}
