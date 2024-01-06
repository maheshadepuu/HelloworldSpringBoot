package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product,Long>
{

}
