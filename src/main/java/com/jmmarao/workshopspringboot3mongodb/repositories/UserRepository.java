package com.jmmarao.workshopspringboot3mongodb.repositories;

import com.jmmarao.workshopspringboot3mongodb.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findById(String id);
    void deleteById(String id);
}
