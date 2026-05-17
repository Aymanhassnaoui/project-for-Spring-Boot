package com.jira.library.book.mapper;

import org.springframework.stereotype.Component;

import com.jira.library.book.dto.request.BookRequest;
import com.jira.library.book.model.BooKEntity;
import com.jira.library.book.dto.response.BookResponse;


@Component
public class BookMapper {

    public BooKEntity toEntity(BookRequest request) {
        BooKEntity book = new BooKEntity();
        book.setTitle(request.getTitle());
        book.setPageNumber(request.getPageNumber());
        book.setPrice(request.getPrice());
        return book;
    }
public BookResponse toResponse(BooKEntity book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getPageNumber(),
                book.getPrice()
        );
    }
}
