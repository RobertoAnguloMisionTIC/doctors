package com.doctors.controller;

import com.doctors.model.Doctor;
import com.doctors.service.DoctorImplementationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorImplementationService doctorImplementationService;

    @GetMapping("/")
    public String index() {
        return "/";
    }

    @PostMapping("/save")
    public boolean createDoctor(@RequestBody Doctor doctor){
        return doctorImplementationService.create(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorImplementationService.doctors();
    }

    @PutMapping("/update")
    public boolean updateDoctor(@RequestBody Doctor doctor){
        return doctorImplementationService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDoctor(@PathVariable ("id") Integer id){
        return doctorImplementationService.delete(id);
    }
}
