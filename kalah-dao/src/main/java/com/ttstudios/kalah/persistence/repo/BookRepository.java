package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);
}
