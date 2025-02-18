package com.monocept.myapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.myapp.entity.Employer;
import com.monocept.myapp.entity.User;
import com.monocept.myapp.entity.UserRole;
import com.monocept.myapp.repository.EmployerRepository;
import com.monocept.myapp.repository.UserRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Employer createEmployee(Employer employer, long userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User with the given user id doesn't exist"));

		user.setRole(UserRole.EMPLOYER);
		employer.setUser(user);
		userRepository.save(user);
		employerRepository.save(employer);
		
		
		return employer;
	}

	@Override
	public User createUser(User user) {
		
		 Optional<User> existingUser = userRepository.findByEmailOrMobile(user.getEmail(), user.getMobile());

		    if (existingUser.isPresent()) {
		        throw new RuntimeException("User with the given email or mobile already exists.");
		    }
		    		    
		    user.setRole(UserRole.USER);
		
		    User savedUser = userRepository.save(user);

		
		return savedUser;
	}

}
