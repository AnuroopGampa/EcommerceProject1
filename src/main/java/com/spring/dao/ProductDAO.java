package com.spring.dao;


import java.util.List;

import com.spring.model.Product;

public interface ProductDAO 
{
	public boolean saveProduct(Product product);
	
	void deleteProduct(int id);
	
	List<Product> getAllProducts();
	
	void addProduct(Product product);
	
	
	
}