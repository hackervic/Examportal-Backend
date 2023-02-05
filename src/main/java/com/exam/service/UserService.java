package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {

    //Create User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //Get user by username
    public User getUser(String username);

    //Delete user by id
    public void deleteUser(Long userID);



}
