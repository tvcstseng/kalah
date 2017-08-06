package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);
}
