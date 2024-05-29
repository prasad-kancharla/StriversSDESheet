package com.prasad.companies.amazon.lld.searchfiles;

public class SearchByFileSizeFilter implements SearchFilter {

    private final int fileSize;

    public SearchByFileSizeFilter(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean apply(File file) {
        return file.getFileSize() == fileSize;
    }

}
