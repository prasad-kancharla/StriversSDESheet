package com.prasad.companies.amazon.lld.searchfiles;

public class SearchByFileTypeFilter implements SearchFilter {

    private final String fileType;

    public SearchByFileTypeFilter(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean apply(File file) {
        return file.getFileType().toString().equalsIgnoreCase(fileType);
    }

}
