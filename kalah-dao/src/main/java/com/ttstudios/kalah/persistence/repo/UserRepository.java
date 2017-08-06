package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(String userName);
}
