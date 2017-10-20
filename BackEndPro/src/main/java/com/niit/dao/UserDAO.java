package com.niit.dao;

import com.niit.model.User;

public interface UserDAO {
	public boolean createUser(User user);
	public boolean getUser(int id);
	public boolean deleteUser(int id);
	public boolean updateUser(User user);
}
