 package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
//	public List<Product> retrieveProduct();

  public boolean createSupplier(Supplier supplier);
  public boolean getSupplier(int id);
  public boolean updateSupplier(Supplier supplier);
  public boolean deleteSupplier(int id);
}
