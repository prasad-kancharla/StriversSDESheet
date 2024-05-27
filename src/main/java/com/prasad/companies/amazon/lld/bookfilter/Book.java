package com.prasad.companies.amazon.lld.bookfilter;

class Book {
    private String title;
    private int pageCount;

    // Assuming the presence of appropriate constructors, getters, and setters

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }
}