package com.jira.library.book.exception;

public class BookNotFoundException extends RuntimeException {


    public BookNotFoundException() {
        super(ErrorCode.BOOK_NOT_FOUND.name() );
    }
    
}
