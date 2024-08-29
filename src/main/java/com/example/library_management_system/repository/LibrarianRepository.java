package com.example.library_management_system.repository;

import com.example.library_management_system.model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<Librarian, String> {
}
