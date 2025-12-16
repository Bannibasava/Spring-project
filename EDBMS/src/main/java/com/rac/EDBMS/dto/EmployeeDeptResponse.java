package com.rac.EDBMS.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeDeptResponse {

    private Integer empId;
    private String ename;
    private String job;
    private Integer age;
    private Integer depId;
    private String dept;
    private String dname;

    

    //  Used by JPQL "new"
    @JsonCreator
    public EmployeeDeptResponse(
            @JsonProperty("empId") Integer empId,
            @JsonProperty("ename") String ename,
            @JsonProperty("job") String job,
            @JsonProperty("age") Integer age,
            @JsonProperty("depId") Integer depId,
            @JsonProperty("dept") String dept,
            @JsonProperty("dname") String dname) {

        this.empId = empId;
        this.ename = ename;
        this.job = job;
        this.age = age;
        this.depId = depId;
        this.dept = dept;
        this.dname = dname;
    }

    // EXPLICIT GETTERS (no Lombok dependency)
    public Integer getEmpId() { return empId; }
    public String getEname() { return ename; }
    public String getJob() { return job; }
    public Integer getAge() { return age; }
    public Integer getDepId() { return depId; }
    public String getDept() { return dept; }
    public String getDname() { return dname; }
}
