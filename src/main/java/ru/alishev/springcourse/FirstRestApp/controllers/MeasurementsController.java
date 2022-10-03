package ru.alishev.springcourse.FirstRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.FirstRestApp.dto.MeasurementsDTO;
import ru.alishev.springcourse.FirstRestApp.models.Measurements;
import ru.alishev.springcourse.FirstRestApp.services.MeasurementsService;

@Controller
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;

    private final ModelMapper meodelMapper;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService, ModelMapper meodelMapper) {
        this.measurementsService = measurementsService;
        this.meodelMapper = meodelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody MeasurementsDTO measurementsDTO,
                                          BindingResult  bindingResult){




        measurementsService.save(convertClassical(measurementsDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public Measurements convertClassical(MeasurementsDTO measurementsDTO){
        return meodelMapper.map(measurementsDTO, Measurements.class);
    }

    public MeasurementsDTO convertToDTO(Measurements measurements){
        return meodelMapper.map(measurements, MeasurementsDTO.class);
    }

}
