package com.exam.repo;

import com.exam.models.User;
import jdk.jfr.BooleanFlag;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);




}
