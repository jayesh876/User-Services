package com.microservice.user.controller;

import com.microservice.user.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @PostMapping(value = "/department/saveDepartment")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department);

    @GetMapping(value = "/department/getAllDepartments")
    public List<Department> getAllDepartments();



}
