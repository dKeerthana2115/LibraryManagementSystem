package java.main.LibraryManagementSystem.BookManagement;

import java.main.LibraryManagementSystem.BranchManagement.Branch;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publishYear;
    private int copiesAvailable;
    private boolean isAvailable;
    private Branch branch;

    public Book(String title, String author, String isbn, String publishYear, int copiesAvailable, Branch branch) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.copiesAvailable = copiesAvailable;
        this.isAvailable = copiesAvailable > 0;
        this.branch = branch;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public boolean isAvailable() {
        return copiesAvailable > 0;
    }

    public Branch getBranch() {
        return branch;
    }

    public String toString() {
        return ("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Publish Year: " + publishYear + ", Copies Available: " + copiesAvailable);
    }

    public void setCopiesAvailable(int i) {
        this.copiesAvailable = i;
        this.isAvailable = i > 0;
    }


}
