package Firstproject.eshop.Dao;

import Firstproject.eshop.Model.UserDetail;

public interface UserDAO 
{
public boolean registerUser(UserDetail user);
public boolean updateUser(UserDetail user);
public boolean deleteUser(UserDetail user);
public UserDetail getUserDetail(String username);
}
