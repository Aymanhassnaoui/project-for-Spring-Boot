package com.jira.library.book.exception;

public class BookAlreadyExistsException extends RuntimeException {

      public BookAlreadyExistsException() {
        super(ErrorCode.BOOK_ALREADY_EXISTS.name());
    }


    
}