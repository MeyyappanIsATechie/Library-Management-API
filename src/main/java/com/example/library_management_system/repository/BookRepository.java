package com.example.library_management_system.repository;

import com.example.library_management_system.model.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {
    // Find all books by author
    List<Book> findByAuthor(String author);

    // Find all available books
    @Query("{ 'isAvailable' : true }")
    List<Book> findAvailableBooks();

    // Custom query for books with a title containing a specific word
    // (case-insensitive)
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Book> findByTitleContaining(String title);
}
