package com.doctors.service;

import com.doctors.model.Doctor;

import java.util.List;

public interface DoctorService {
    public boolean create(Doctor doctor);
    public List<Doctor> doctors();
    public boolean update(Doctor doctor);
    public boolean delete(Integer id);
}
