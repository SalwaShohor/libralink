package com.dareshuri.libralink.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Iterable<User> findAllByRole(String role);
    User findByUsernameAndPassword(String username, String password);

}
