package com.wp.project.beautysalon.service;

import com.wp.project.beautysalon.model.Termin;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public interface TerminService {

    List<Termin> findAll();

    Termin findbyId(Integer id);

    public Termin create(LocalDateTime startTime, Float duration, String employeeId);

    public Termin update(Integer id, LocalDateTime startTime,  Float duration, String employeeId);
}
