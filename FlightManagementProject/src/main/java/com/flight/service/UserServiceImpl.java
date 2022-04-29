package com.flight.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.UserDAO;
//import com.flight.entities.Booking;
import com.flight.entities.Users;
import com.flight.exceptions.UserNotFoundException;
import com.flight.exceptions.ValueNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userdao;
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}
	@Override
	public Users addUser(Users users) throws ValueNotFoundException {

		if(users.getFirstname().isEmpty() || users.getFirstname().length()==0) {
			throw new ValueNotFoundException();
		}
		else {
	Users u=userdao.save(users);
		return u;
		}
		
		}
	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		userdao.save(user);
		return user;
	}
	
	@Override
	public List<Users> GetRelatedUser() {
		// TODO Auto-generated method stub
		return userdao.getUser();
	}
	@Override
	public List<Users> GetUserName() {
		// TODO Auto-generated method stub
		return userdao.getname();
	}
	@Override
	public Users getUserById(int id)throws UserNotFoundException {
		Users u;
		if(userdao.findById(id).isEmpty()) {
			throw new UserNotFoundException();
		}
		else {
			u=userdao.findById(id).get();
		}
		return u;

}
}
