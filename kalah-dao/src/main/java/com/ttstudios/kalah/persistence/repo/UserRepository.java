package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(String userName);
}
