package com.example.OneToOne.service;

import com.example.OneToOne.dto.PersonDTO;
import com.example.OneToOne.entity.Aadhaar;
import com.example.OneToOne.entity.Person;
import com.example.OneToOne.repository.AadhaarRepository;
import com.example.OneToOne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AadhaarRepository aadhaarRepository;

    @Override
    public PersonDTO savePerson(PersonDTO dto) {

        // 1️ Find Aadhaar by ID
        Aadhaar aadhaar = aadhaarRepository.findById(dto.getAadhaarId())
                .orElseThrow(() -> new RuntimeException("Aadhaar not found"));

        // 2️ Create Person entity
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setAadhaar(aadhaar);

        // 3️ Save Person
        personRepository.save(person);

        // 4️ Return DTO
        return dto;
    }
}
