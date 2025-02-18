package com.monocept.myapp.service;

import com.monocept.myapp.entity.Employer;
import com.monocept.myapp.entity.User;

public interface JobService {


	Employer createEmployee(Employer employer, long userId);

	User createUser(User user);


}
