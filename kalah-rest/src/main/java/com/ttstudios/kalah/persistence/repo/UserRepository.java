package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.Book;
import com.ttstudios.kalah.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(String userName);
}
