package com.example.library_management_system.controller;

import com.example.library_management_system.model.Librarian;
import com.example.library_management_system.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    @GetMapping
    public List<Librarian> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }

    @GetMapping("/{id}")
    public Librarian getLibrarianById(@PathVariable String id) {
        return librarianService.getLibrarianById(id);
    }

    @PostMapping
    public Librarian addLibrarian(@RequestBody Librarian librarian) {
        return librarianService.saveLibrarian(librarian);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrarian(@PathVariable String id) {
        librarianService.deleteLibrarian(id);
    }
}
