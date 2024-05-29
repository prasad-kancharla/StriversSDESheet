package com.prasad.companies.amazon.lld.searchfiles;

public class SearchByFileNameFilter implements SearchFilter {

    private final String fileName;

    public SearchByFileNameFilter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean apply(File file) {
        return file.getFileName().equals(fileName);
    }

}
