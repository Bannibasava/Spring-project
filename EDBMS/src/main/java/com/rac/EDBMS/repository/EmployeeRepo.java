package com.rac.EDBMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rac.EDBMS.dto.EmployeeDeptResponse;
import com.rac.EDBMS.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query("""
        SELECT new com.rac.EDBMS.dto.EmployeeDeptResponse(
            e.empId, e.ename, e.job, e.age,
            d.depId, d.dept, d.dname
        )
        FROM Employee e, Department d
        WHERE e.dept = d.dept
          AND d.dept = :code
    """)
    List<EmployeeDeptResponse> findEmployeeWithDeptByCode(@Param("code") String code);
}
