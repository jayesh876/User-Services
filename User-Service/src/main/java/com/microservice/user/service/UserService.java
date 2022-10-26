package com.microservice.user.service;

import com.microservice.user.entity.User1;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User1 saveUser(User1 user);
    public List<User1> getAllUsers();
    public List getAllUsersAndDepartments();
}
