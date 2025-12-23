package com.rac.EDBMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rac.EDBMS.dto.EmployeeDTO;
import com.rac.EDBMS.dto.EmployeeDeptResponse;
import com.rac.EDBMS.entities.Employee;

public interface EmployeeService {
	
	EmployeeDTO saveEmp( EmployeeDTO e);
	
	List<EmployeeDTO> getAllStudent(String sortBy);
	
	ResponseEntity<List<EmployeeDeptResponse>> getByDept(String code);
	
	EmployeeDTO updateById(Integer id, Employee newEmp);
	
	String deleteEmp( Integer id);

}
