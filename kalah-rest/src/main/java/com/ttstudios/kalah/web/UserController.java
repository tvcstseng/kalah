package com.ttstudios.kalah.web;

import com.ttstudios.kalah.persistence.model.User;
import com.ttstudios.kalah.persistence.repo.UserRepository;
import com.ttstudios.kalah.web.exception.UserIdMismatchException;
import com.ttstudios.kalah.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/users" )
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/userName/{userName}")
    public List<User> findByTitle(@PathVariable String userName) {
        return repository.findByUserName(userName);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        final User user = repository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        final User user = repository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        repository.delete(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new UserIdMismatchException();
        }
        final User old = repository.findOne(id);
        if (old == null) {
            throw new UserNotFoundException();
        }
        return repository.save(user);
    }

}

