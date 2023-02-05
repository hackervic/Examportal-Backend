package com.exam.service;

import com.exam.models.exam.Catagory;

import java.util.Set;

public interface CatagoryService {

    public Catagory addCategory(Catagory category);

    public Catagory updateCategory(Catagory category);

    public Set<Catagory> getCategories();

    public Catagory getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);





}
