package com.entryPass.admin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.entryPass.admin.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

}
