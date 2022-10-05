package com.doctors.service;

import com.doctors.model.Doctor;
import com.doctors.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorImplementationService implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional
    public boolean create(Doctor doctor) {
        if(doctor.getId() != null){
            if(doctorRepository.existsById(doctor.getId())){
                return false;
            }else{
                doctorRepository.save(doctor);
                return true;
            }
        }else {
            doctorRepository.save(doctor);
            return true;
        }
    }

    @Override
    public List<Doctor> doctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    @Transactional
    public boolean update(Doctor doctor) {
        if (doctorRepository.existsById(doctor.getId())){
            doctorRepository.save(doctor);
            return true;
        }else
            return false;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
