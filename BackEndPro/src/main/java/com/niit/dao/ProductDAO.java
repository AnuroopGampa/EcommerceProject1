package com.niit.dao;



import com.niit.model.Product;

public interface ProductDAO {
	
	
	
//	public List<Product> retrieveProduct();

  public boolean createProduct(Product product);
  public boolean getProduct(int id);
  public boolean updateProduct(Product product);
  public boolean deleteProduct(int id);
   
}
