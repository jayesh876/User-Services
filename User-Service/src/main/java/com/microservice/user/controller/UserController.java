package com.microservice.user.controller;

import com.microservice.user.entity.User1;
import com.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

   @Autowired
   private DepartmentClient departmentClient;

    /*
        URL : http://localhost:9002/user/saveUser
        HTTP Method : POST
        {
          "firstName":"Raj",
          "lastName":"Prudhvi",
          "email":"prudhvi@gmail.com"
        }
     */
    @PostMapping(value = "/saveUser")
    public ResponseEntity<User1> saveUser(@RequestBody RequestObject ro){
        User1 savedUser=userService.saveUser(ro.getUser());
        departmentClient.saveDepartment(ro.getDepartment());
        return new ResponseEntity<User1>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<List<User1>> getAllUsers(){

           return new ResponseEntity<List<User1>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUsersAndDepartments")
    public ResponseEntity<List> getAllUsersAndDepartments(){

        return new ResponseEntity<List>(userService.getAllUsersAndDepartments(), HttpStatus.OK);
    }



}
