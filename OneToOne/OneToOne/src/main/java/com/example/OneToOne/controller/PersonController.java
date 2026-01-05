package com.example.OneToOne.controller;

import com.example.OneToOne.dto.PersonDTO;
import com.example.OneToOne.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/save")
    public PersonDTO savePerson(@RequestBody PersonDTO dto) {
        return service.savePerson(dto);
    }
}
