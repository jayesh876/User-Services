package com.microservice.user.service;

import com.microservice.user.controller.DepartmentClient;
import com.microservice.user.entity.Department;
import com.microservice.user.entity.User1;
import com.microservice.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentClient departmentClient;

    @Override
    public User1 saveUser(User1 user) {
        log.info("inside saveUser() method .....");
        return userRepository.save(user);
    }

    @Override
    public List<User1> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List getAllUsersAndDepartments() {
       List<Department> allDepartments=departmentClient.getAllDepartments();
       List<User1> allUsers=userRepository.findAll();
       List allUsersAndDepartments= Stream.of(allDepartments,allUsers).collect(Collectors.toList());
       return allUsersAndDepartments;
    }



}
