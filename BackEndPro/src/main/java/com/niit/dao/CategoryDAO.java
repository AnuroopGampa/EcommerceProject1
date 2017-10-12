package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {
 public boolean updateCategory(Category category);
 public boolean deleteCategory(int id);
 //public List<Category> listCategory();
 public boolean createCategory(Category category);
 public boolean getCategory(int id);
}
