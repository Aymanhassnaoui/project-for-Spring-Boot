package com.jira.library.book.dto.response;

public class BookResponse {

    private Long id;
    private String title;
    private Integer pageNumber;
    private Integer price;

    public BookResponse(Long id, String title, Integer pageNumber, Integer price) {
        this.id = id;
        this.title = title;
        this.pageNumber = pageNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

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
