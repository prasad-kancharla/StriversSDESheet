package com.prasad.companies.amazon.lld.bookfilter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookFilterExample {

    public static boolean bookPassesFilters(Book book, List<BookFilter> filters) {
        for (BookFilter filter : filters) {
            if (!filter.apply(book)) {
                return false;
            }
        }
        return true;
    }

    public static Set<Book> filterBooks(List<Book> bookList, List<BookFilter> filters) {
        Set<Book> rval = new HashSet<>();
        for (Book book : bookList) {
            if (bookPassesFilters(book, filters)) {
                rval.add(book);
            }
        }
        return rval;
    }

}
