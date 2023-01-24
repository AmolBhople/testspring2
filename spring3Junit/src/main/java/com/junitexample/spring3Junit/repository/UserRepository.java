package com.junitexample.spring3Junit.repository;


import com.junitexample.spring3Junit.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);
    Optional<User> findByFirstName(String firstName);
    List<User> findByAge(int age);

}
