package com.rac.EDBMS.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rac.EDBMS.dto.EmployeeDTO;
import com.rac.EDBMS.dto.EmployeeDeptResponse;
import com.rac.EDBMS.entities.Employee;
import com.rac.EDBMS.repository.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo repo;

    @Override
    public EmployeeDTO saveEmp(EmployeeDTO empDto) {
        Employee empEntity = new Employee();
        empEntity.setEname(empDto.getName());
        empEntity.setAge(empDto.getAge());
        empEntity.setJob(empDto.getJob());
        empEntity.setDept(empDto.getDept());

        Employee savedEmp = repo.save(empEntity);

        return mapToDTO(savedEmp);
    }

    @Override
    public List<EmployeeDTO> getAllStudent(String sortBy) {
        List<Employee> empList =
                repo.findAll(Sort.by(sortBy).ascending());

        List<EmployeeDTO> dtoList = new java.util.ArrayList<>();

        for (Employee emp : empList) {
            dtoList.add(mapToDTO(emp));
        }

        return dtoList;
    }

    @Override
    public ResponseEntity<List<EmployeeDeptResponse>> getByDept(String code) {
        List<EmployeeDeptResponse> list =
                repo.findEmployeeWithDeptByCode(code);
        return ResponseEntity.ok(list);
    }

    @Override
    public EmployeeDTO updateById(Integer id, Employee newEmp) {
        Employee oldEmp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee doesn't exist!!"));

        oldEmp.setEname(newEmp.getEname());
        oldEmp.setJob(newEmp.getJob());
        oldEmp.setAge(newEmp.getAge());
        oldEmp.setDept(newEmp.getDept());

        Employee updatedEmp = repo.save(oldEmp);

        return mapToDTO(updatedEmp);
    }


    @Override
    public String deleteEmp(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Emp with id " + id + " deleted!!!";
        }
        return "Emp with id " + id + " does not exist!!!";
    }

    private EmployeeDTO mapToDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(emp.getEname());
        dto.setAge(emp.getAge());
        dto.setJob(emp.getJob());
        dto.setDept(emp.getDept());
        return dto;
    }
}
