package com.api.fullstack.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.fullstack.model.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

}
