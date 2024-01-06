package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Category;


public interface CategoryJpaRepository extends JpaRepository<Category,Long>
{

}
