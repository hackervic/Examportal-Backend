package com.exam.repo;
import com.exam.models.exam.Catagory;
import com.exam.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
