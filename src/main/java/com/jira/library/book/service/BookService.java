package com.jira.library.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.jira.library.book.dto.request.BookRequest;
import com.jira.library.book.dto.response.BookResponse;
import com.jira.library.book.exception.BookAlreadyExistsException;
import com.jira.library.book.exception.BookNotFoundException;
import com.jira.library.book.mapper.BookMapper;
import com.jira.library.book.model.BooKEntity;
import com.jira.library.book.persistence.BookRepository;

import java.util.List;

@Service // Dit à Spring que c'est ici que se passe la logique métier
@RequiredArgsConstructor // Génère le constructeur pour bookRepository automatiquement
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookResponse createBook(BookRequest request) {
        // On déplace la vérification ici
        if (bookRepository.existsByPageNumberAndTitle(request.getPageNumber(), request.getTitle())) {
            throw new BookAlreadyExistsException();
        }

        BooKEntity book = bookMapper.toEntity(request);

        BooKEntity saved = bookRepository.save(book);
        return bookMapper.toResponse(saved);

    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    public BookResponse getBookById(Long id) {

        BooKEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());
        return bookMapper.toResponse(book);
    }

    public void deleteBook(Long id) {
        // On vérifie si l'ID existe avant de supprimer
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Suppression impossible : l'ID " + id + " n'existe pas.");
        }
        bookRepository.deleteById(id);
    }

}