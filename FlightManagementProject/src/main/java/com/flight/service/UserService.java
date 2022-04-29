package com.flight.service;

import java.util.List;
import java.util.Optional;

import com.flight.entities.Users;
import com.flight.exceptions.UserNotFoundException;
import com.flight.exceptions.ValueNotFoundException;

public interface UserService {
	public List<Users> getUsers();
	public Users addUser(Users user )throws ValueNotFoundException;
	public Users updateUser(Users user);
	public Users getUserById(int id)throws UserNotFoundException;
	public List<Users> GetRelatedUser();
	public List<Users> GetUserName();
	

}
