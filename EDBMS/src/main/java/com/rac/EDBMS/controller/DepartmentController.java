package com.rac.EDBMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.EDBMS.entities.Department;
import com.rac.EDBMS.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private final DepartmentService service;

    @PostMapping("/save")
    public Department saveDept(@RequestBody Department d) {
    	 return service.saveDept( d);
    }
}
