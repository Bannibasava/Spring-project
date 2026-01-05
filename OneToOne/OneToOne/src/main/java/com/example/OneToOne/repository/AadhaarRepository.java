package com.example.OneToOne.repository;

import com.example.OneToOne.entity.Aadhaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadhaarRepository extends JpaRepository<Aadhaar, Long> {
}
