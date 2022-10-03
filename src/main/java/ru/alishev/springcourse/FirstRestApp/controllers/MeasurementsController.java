package ru.alishev.springcourse.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.FirstRestApp.models.Measurements;
import ru.alishev.springcourse.FirstRestApp.services.MeasurementsService;

@Controller
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody Measurements measurements,
                                          BindingResult  bindingResult){


        System.out.println(measurements.getSensor().getName());
        System.out.println(measurements.getValue());
        System.out.println(measurements.isRaining());

        Measurements measurements1 = new Measurements();

        measurements1.setRaining(measurements.isRaining());
        measurements1.setSensor(measurements.getSensor());
        measurements1.setValue(measurements.getValue());

        System.out.println(measurements1.getSensor());

//        measurementsService.save(measurements);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
