package com.example.OneToOne.service;

import com.example.OneToOne.dto.AadhaarDTO;
import com.example.OneToOne.entity.Aadhaar;
import com.example.OneToOne.repository.AadhaarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AadhaarServiceImpl implements AadhaarService {

    @Autowired
    private AadhaarRepository repository;

    @Override
    public AadhaarDTO saveAadhar(AadhaarDTO dto) {

        Aadhaar aadhaar = new Aadhaar();
        aadhaar.setAadhaarNumber(dto.getAadhaarNumber());

        Aadhaar saved = repository.save(aadhaar);

        return new AadhaarDTO(saved.getAadhaarNumber());
    }
}
