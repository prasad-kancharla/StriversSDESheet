package com.prasad.companies.amazon.lld.searchfiles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchFilesExample {

    public Set<File> searchFiles(List<File> files, List<SearchFilter> searchFilters) {
        Set<File> filteredFiles = new HashSet<>();
        for (File file : files) {
            boolean isFiltered = true;
            for (SearchFilter searchFilter : searchFilters) {
                if (!searchFilter.apply(file)) {
                    isFiltered = false;
                }
            }
            if (isFiltered) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }

}
