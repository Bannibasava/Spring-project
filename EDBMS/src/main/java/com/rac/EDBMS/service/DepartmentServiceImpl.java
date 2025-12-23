package com.rac.EDBMS.service;

import org.springframework.stereotype.Service;

import com.rac.EDBMS.entities.Department;
import com.rac.EDBMS.repository.DepartmentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private final DepartmentRepo repo;

	@Override
	public Department saveDept(Department d) {
		  return repo.save(d);
	}

}
