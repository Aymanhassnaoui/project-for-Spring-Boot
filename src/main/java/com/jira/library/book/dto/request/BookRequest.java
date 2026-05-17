package com.jira.library.book.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookRequest {
    
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String title;

    @Min(value = 1, message = "Le nombre de pages doit être au moins 1")
    private Integer pageNumber;

    @Min(value = 0, message = "Le prix doit être au moins 0")
    @Column(columnDefinition = "INT CHECK (price >= 0)")
    private Integer price;

    public String getTitle() {
        return title;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPrice() {
        return price;
    }

}
