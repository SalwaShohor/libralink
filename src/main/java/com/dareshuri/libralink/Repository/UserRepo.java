package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {}
