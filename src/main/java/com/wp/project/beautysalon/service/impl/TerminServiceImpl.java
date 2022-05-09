package com.wp.project.beautysalon.service.impl;

import com.wp.project.beautysalon.model.Termin;
import com.wp.project.beautysalon.model.User;
import com.wp.project.beautysalon.model.exceptions.InvalidArgumentException;
import com.wp.project.beautysalon.model.exceptions.InvalidTerminIdException;
import com.wp.project.beautysalon.repository.TerminRepository;
import com.wp.project.beautysalon.repository.UserRepository;
import com.wp.project.beautysalon.service.TerminService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;
    private final UserRepository userRepository;

    public TerminServiceImpl(TerminRepository terminRepository, UserRepository userRepository) {
        this.terminRepository = terminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Termin> findAll() {
        return this.terminRepository.findAll();
    }

    @Override
    public Termin findbyId(Integer id) {
        return this.terminRepository.findById(id).orElseThrow(InvalidArgumentException::new);
    }

    @Override
    public Termin create(LocalDateTime startTime, Float duration, String employeeId) {
        User employee = this.userRepository.getById(employeeId);
        Termin termin = new Termin(startTime, duration, employee);
        return this.terminRepository.save(termin);
    }

    @Override
    public Termin update(Integer id, LocalDateTime startTime,  Float duration, String employeeId) {

        Termin termin = this.terminRepository.findById(id).orElseThrow(InvalidTerminIdException::new);
        User employee = this.userRepository.getById(employeeId);
        termin.setStartTime(startTime);
        termin.setDuration(duration);
        termin.setEmployee(employee);

        return this.terminRepository.save(termin);
    }
}
