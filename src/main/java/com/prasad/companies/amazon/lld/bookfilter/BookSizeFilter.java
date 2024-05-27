package com.prasad.companies.amazon.lld.bookfilter;

class BookSizeFilter extends BookFilter {
    private BookSize desiredSize;

    public BookSizeFilter(BookSize desiredSize) {
        this.desiredSize = desiredSize;
    }

    @Override
    public boolean apply(Book book) {
        int minPages = 0;
        int maxPages = 0;

        switch (desiredSize) {
            case BIG:
                minPages = 0;
                maxPages = 100;
                break;
            case MEDIUM:
                minPages = 101;
                maxPages = 500;
                break;
            case SMALL:
                minPages = 501;
                maxPages = Integer.MAX_VALUE;
                break;
        }
        return (book.getPageCount() >= minPages) && (book.getPageCount() < maxPages);
    }
}