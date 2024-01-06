package com.project.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Product;
import com.project.service.ProductJpaService;


@RestController
public class ProductController 
{
	@Autowired
	private ProductJpaService  productService;

    @GetMapping("/products")
    public ArrayList<Product> getProduct()
	{
	  return productService.getProduct();
	}
    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable("productId") long productId) 
	{
		return productService.getProductById(productId);
	}
   
    @PostMapping("/category/products/addnewproduct")
    public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
    
    @PutMapping("products/{productId}")
    public Product updateProduct(@PathVariable("productId") long productId, @RequestBody Product product) 
    {
		return productService.updateProduct(productId, product);
    }
    
    @DeleteMapping("products/{productId}")
    public void deleteProduct(@PathVariable("productId") long productId)
    {
    	productService.deleteProduct(productId);
    }
}

