package com.monocept.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.myapp.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>{

}
