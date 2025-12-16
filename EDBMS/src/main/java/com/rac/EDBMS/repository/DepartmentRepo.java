package com.rac.EDBMS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rac.EDBMS.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}

