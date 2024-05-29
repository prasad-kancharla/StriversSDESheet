package com.prasad.companies.amazon.lld.searchfiles;

import java.time.LocalDate;

public class File {

    static long id = 1;

    private long fileId;
    private FileType fileType;
    private String fileName;
    private int fileSize;
    private final LocalDate createdDate;

    public File(FileType fileType, String fileName, int fileSize) {
        this.fileId = id;
        id++;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.createdDate = LocalDate.now();
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

}
