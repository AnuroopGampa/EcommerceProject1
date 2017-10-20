package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.Category;

public interface CartDAO {
	public boolean saveCart(Cart cart);
	public boolean deleteCart(int Cid);
	public List<Cart> getAllCartList();
	public boolean updateCart(int Cid);
	public boolean getCartbyId(int Cid);



} 
