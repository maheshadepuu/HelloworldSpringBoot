package com.project.repository;

import java.util.ArrayList;

import com.project.model.Category;
import com.project.model.Product;

public interface ProductRepository
{
	ArrayList<Product> getProduct();
	Product getProductById(long productId);
	Product addProduct(Product product);
	Product updateProduct(long productId, Product product);
	void deleteProduct(long productId);
}

