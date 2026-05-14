package com.jira.library.book.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jira.library.book.model.BooKEntity;
import com.jira.library.book.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor // Génère le constructeur pour bookService automatiquement
public class BookController {

    // Get POUR AFFICHER TOUS LES LIVRES
    // POST POUR AJOUTER UN LIVRE

    private final BookService bookService; // On injecte le SERVICE, plus le repository



  @PostMapping("/book")
   public ResponseEntity<BooKEntity> create(@Valid @RequestBody BooKEntity book) {
        BooKEntity savedBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }


    @GetMapping("/books/all")
    public ResponseEntity<List<BooKEntity>> list() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/book/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Livre supprimé avec succès.");
    }



}
