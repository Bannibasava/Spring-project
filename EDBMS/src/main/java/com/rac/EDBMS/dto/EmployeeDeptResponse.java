package com.rac.EDBMS.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeDeptResponse {

    private Integer empId;
    private String ename;
    private String job;
    private Integer age;
    private Integer depId;
    private String dept;
    private String dname;


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

}
