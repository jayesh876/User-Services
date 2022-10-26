package com.microservice.user.controller;

import com.microservice.user.entity.Department;
import com.microservice.user.entity.User1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestObject {
    private User1 user;
    private Department department;
}
