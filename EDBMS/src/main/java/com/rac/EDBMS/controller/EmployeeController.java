package com.rac.EDBMS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rac.EDBMS.dto.EmployeeDTO;
import com.rac.EDBMS.dto.EmployeeDeptResponse;
import com.rac.EDBMS.entities.Employee;
import com.rac.EDBMS.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

   

    @PostMapping("/save")
    public EmployeeDTO saveDept(@RequestBody EmployeeDTO e) {
        return service.saveEmp(e);
    }

    @GetMapping("/gettall")
    public List<EmployeeDTO> getAllStudent(@RequestParam(required = false,defaultValue = "ename") String sortBy) {
        return service.getAllStudent(sortBy);
    }

    @GetMapping("/by-dept/{code}")
    public ResponseEntity<List<EmployeeDeptResponse>> getByDept(@PathVariable String code) {
        return getByDept( code);
    }
    
    @PutMapping("/updateById/{id}")
    public EmployeeDTO updateById(
            @PathVariable Integer id,
            @RequestBody Employee newEmp) {
        return service.updateById(id,newEmp);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable Integer id){
        return deleteEmp(id);
    }


}
