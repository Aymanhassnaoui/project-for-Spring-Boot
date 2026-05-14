package com.jira.library.book.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.jira.library.book.model.BooKEntity;
import com.jira.library.book.persistence.BookRepository;

import java.util.List;

@Service // Dit à Spring que c'est ici que se passe la logique métier
@RequiredArgsConstructor // Génère le constructeur pour bookRepository automatiquement
public class BookService {

    private final BookRepository bookRepository;

    public BooKEntity createBook( BooKEntity book) {
        // On déplace la vérification ici
        if (bookRepository.existsByPageNumberAndTitle(book.getPageNumber(), book.getTitle())) {
            throw new RuntimeException("Le livre existe déjà");
        }


        return bookRepository.save(book);
    }

    public List<BooKEntity> getAllBooks() {
        return bookRepository.findAll();
    }




    public void deleteBook(Long id) {
        // On vérifie si l'ID existe avant de supprimer
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Suppression impossible : l'ID " + id + " n'existe pas.");
        }
        bookRepository.deleteById(id);
    }


    
}