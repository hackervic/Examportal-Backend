package com.exam.service.impl;

import com.exam.models.exam.Catagory;
import com.exam.repo.CategoryRepository;
import com.exam.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Catagory addCategory(Catagory category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Catagory updateCategory(Catagory category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Catagory> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Catagory getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Catagory category = new Catagory();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
    }

}
