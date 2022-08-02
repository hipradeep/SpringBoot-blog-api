package com.hipradeep.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hipradeep.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
