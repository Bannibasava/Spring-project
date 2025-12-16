package com.rac.EDBMS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rac.EDBMS.dto.EmployeeDeptResponse;
import com.rac.EDBMS.entities.Employee;
import com.rac.EDBMS.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepo repo;

    public EmployeeController(EmployeeRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/save")
    public Employee saveDept(@RequestBody Employee e) {
        return repo.save(e);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/by-dept/{code}")
    public ResponseEntity<List<EmployeeDeptResponse>> getByDept(@PathVariable String code) {

        List<EmployeeDeptResponse> list =
                repo.findEmployeeWithDeptByCode(code);

        return ResponseEntity.ok(list);
    }
    
    @PutMapping("/updateById/{id}")
    public Employee updateById(
            @PathVariable Integer id,
            @RequestBody Employee newEmp) {

        Employee oldEmp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee doesn't exist!!"));

        oldEmp.setEname(newEmp.getEname());
        oldEmp.setJob(newEmp.getJob());
        oldEmp.setAge(newEmp.getAge());
        oldEmp.setDept(newEmp.getDept()); 

        return repo.save(oldEmp);
    }


}
