package com.example.library_management_system.service;

import com.example.library_management_system.model.Librarian;
import com.example.library_management_system.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    public Librarian getLibrarianById(String id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian saveLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public void deleteLibrarian(String id) {
        librarianRepository.deleteById(id);
    }
}
