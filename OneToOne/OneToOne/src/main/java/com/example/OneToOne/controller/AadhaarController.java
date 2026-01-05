package com.example.OneToOne.controller;

import com.example.OneToOne.dto.AadhaarDTO;
import com.example.OneToOne.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aadhaar")
public class AadhaarController {

    @Autowired
    private AadhaarService service;

    @PostMapping("/save")
    public AadhaarDTO saveAadhaar(@RequestBody AadhaarDTO e) {
        return service.saveAadhar(e);
    }
}
