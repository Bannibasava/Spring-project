package com.rac.EDBMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rac.EDBMS.entities.Department;
import com.rac.EDBMS.repository.DepartmentRepo;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepo repo;

    @PostMapping("/save")
    public Department saveDept(@RequestBody Department d) {
        return repo.save(d);
    }
}
