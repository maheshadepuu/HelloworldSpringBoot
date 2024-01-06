package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.project.model.Category;
import com.project.model.Product;
import com.project.repository.CategoryJpaRepository;
import com.project.repository.ProductJpaRepository;
import com.project.repository.ProductRepository;


@Service
public class ProductJpaService implements ProductRepository
{
	@Autowired
	public ProductJpaRepository productJpaRepository;
	@Autowired
    public CategoryJpaRepository categoryJpaRepository;
	@Override
	public ArrayList<Product> getProduct() {
		List<Product> productList=productJpaRepository.findAll();
		ArrayList<Product> products=new ArrayList<>(productList);
		return products;
	}

	@Override
	public Product getProductById(long productId) {
		try
		{
		Product	 product= productJpaRepository.findById(productId).get();
		return product;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Product addProduct(Product product) {

		Category category=product.getCategory(); 
		 
		 long categoryId=category.getId(); 
		 try 
		 {
			 Category category1=categoryJpaRepository.findById(categoryId).get();
		     product.setCategory(category1);
		    productJpaRepository.save(product);
		     return product;
		 }
		 catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		 
	}

	@Override
	public Product updateProduct(long productId, Product product) {

		try
		{
		Product existingProduct= productJpaRepository.findById(productId).get();
		if(product.getName()!=null)
		{
			existingProduct.setName(product.getName());
		}
		
		if(product.getDescription()!=null)
		{
			existingProduct.setDescription(product.getDescription());
		}
		if(product.getCategory()!=null)
		{
			Category category=product.getCategory(); 
			long categoryId=category.getId(); 
			Category newCategory=categoryJpaRepository.findById(categoryId).get();
			existingProduct.setCategory(newCategory);
		}
		productJpaRepository.save(existingProduct);


		return existingProduct;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteProduct(long productId) {
		try 
		{
		Product product= productJpaRepository.findById(productId).get();
		if(product!=null)
		{
			productJpaRepository.deleteById(productId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

}
