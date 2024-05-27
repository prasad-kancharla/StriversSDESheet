package com.prasad.companies.amazon.lld.bookfilter;

class TitleFilter extends BookFilter {
    private String title;

    public TitleFilter(String title) {
        this.title = title;
    }

    @Override
    public boolean apply(Book book) {
        return book.getTitle().contains(title);
    }
}