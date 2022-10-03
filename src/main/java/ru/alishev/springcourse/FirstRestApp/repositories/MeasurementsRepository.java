package ru.alishev.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.FirstRestApp.models.Measurements;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements,Integer> {


}
