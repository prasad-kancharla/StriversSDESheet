package com.prasad.companies.amazon.lld.searchfiles;

import java.time.LocalDate;

public class SearchByCreationDateFilter implements SearchFilter {

    private final LocalDate creationDate;

    public SearchByCreationDateFilter(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean apply(File file) {
        return file.getCreatedDate().isEqual(creationDate);
    }

}
