package com.exam.controller;

import com.exam.helper.UserFoundException;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating User
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfile("default.png");
        Set<UserRole> roles= new HashSet<>();
        Role role = new Role();
        role.setRole(45L);
        role.setRoleName("USER");


        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        try {
            return this.userService.createUser(user,roles);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
    return this.userService.getUser(username);
    }

    @DeleteMapping("/{userID}")
    public void deleteUser(@PathVariable("userID") Long userID){
        this.userService.deleteUser(userID);
    }

@ExceptionHandler(UserFoundException.class)
    public String responseEntity(UserFoundException ex){
        return ex.getMessage();
}

}
//    Migrating the Database from Netezza to Azure Cloud using IICS(ETL) Tool.
//        Creating Workflow using Informatica PowerCenter and Intelligent Informatica Cloud Platform (IICS).
//        Creating and deploying Autosys job.
//        Automating the Workflows for ETL Process through Autosys.
//        Creating and fixing Unix Script.
//        Converting Query in T-Sql format.
