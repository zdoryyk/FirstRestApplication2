package ru.alishev.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alishev.springcourse.FirstRestApp.models.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData,Integer> {


}
