package com.ttstudios.kalah.persistence.repo;

import java.util.List;

import com.ttstudios.kalah.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
