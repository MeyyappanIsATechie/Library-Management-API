package com.example.library_management_system.service;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.model.Member;
import com.example.library_management_system.repository.BookRepository;
import com.example.library_management_system.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public String borrowBook(String bookId, String memberId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (book == null || member == null) {
            return "Book or Member not found.";
        }

        if (!book.isAvailable()) {
            return "Book is currently unavailable.";
        }

        book.setAvailable(false);
        member.setBorrowedBooksCount(member.getBorrowedBooksCount() + 1);

        bookRepository.save(book);
        memberRepository.save(member);

        return "Book borrowed successfully.";
    }

    public String returnBook(String bookId, String memberId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (book == null || member == null) {
            return "Book or Member not found.";
        }

        if (book.isAvailable()) {
            return "Book is not currently borrowed.";
        }

        book.setAvailable(true);
        member.setBorrowedBooksCount(member.getBorrowedBooksCount() - 1);

        bookRepository.save(book);
        memberRepository.save(member);

        return "Book returned successfully.";
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
