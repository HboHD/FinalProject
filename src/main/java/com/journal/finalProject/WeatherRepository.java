package com.journal.finalProject;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherReport, Long> {
    List<WeatherReport> findByCity(String city);
}
