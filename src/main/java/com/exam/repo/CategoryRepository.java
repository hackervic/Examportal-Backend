package com.exam.repo;
import com.exam.models.exam.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Catagory, Long> {




}
