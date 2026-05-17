package com.jira.library.book.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jira.library.book.dto.request.BookRequest;
import com.jira.library.book.dto.response.BookResponse;
import com.jira.library.book.model.BooKEntity;
import com.jira.library.book.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books") // Préfixe pour toutes les routes de ce contrôleur
@RequiredArgsConstructor // Génère le constructeur pour bookService automatiquement
public class BookController {

    // POST POUR AJOUTER UN LIVRE

    private final BookService bookService; // On injecte le SERVICE, plus le repository



  @PostMapping
   public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest book) {
        BookResponse savedBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }


    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> list() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) {        
        BookResponse book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/book/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Livre supprimé avec succès.");
    }



}
