package java.main.LibraryManagementSystem.PatronManagement;

import java.time.LocalDate;
import java.util.*;
import java.main.LibraryManagementSystem.BookManagement.Book;

public class Patron {
    private String name;
    private String patronId;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks;
    private int maxBooksAllowed;
    private double fine;
    private List<BorrowRecords> history;

    public Patron(String name, String patronId, String email, String phoneNumber, int maxBooksAllowed) {
        this.name = name;
        this.patronId = patronId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
        this.maxBooksAllowed = maxBooksAllowed;
        this.fine = 0.0;
        this.history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }

    public double getFine() {
        return fine;
    }

    public void borrowBook(Book book) {
        if(borrowedBooks.size() < maxBooksAllowed) {
            borrowedBooks.add(book);
            int copies = book.getCopiesAvailable();
            book.setCopiesAvailable(copies - 1);
            System.out.println("Book borrowed: " + book.getTitle());
            history.add(new BorrowRecords(patronId, book.getIsbn(), LocalDate.now()));
        } else {
            System.out.println("Cannot borrow more books. Limit reached.");
        }
    }

    public void removeBook(Book book) {
        if(borrowedBooks.remove(book)) {
            System.out.println("Book returned: " + book.getTitle());
            int copies = book.getCopiesAvailable();
            book.setCopiesAvailable(copies + 1);
            for(BorrowRecords record : history) {
                if(record.getBookIsbn().equals(book.getIsbn()) && record.getReturnDate() == null) {
                    record.setReturnDate(LocalDate.now());
                    break;
                }
            }
        } else {
            System.out.println("This book was not borrowed by the patron.");
        }
    }

    public void displayBorrowHistory() {
        for(BorrowRecords record : history) {
            System.out.println(record.toString());
        }
    }

    public void addFine(double amount) { fine += amount; }

    public void clearFine() { fine = 0.0; }

    @Override
    public String toString() {
        return "Patron [ID=" + patronId + ", Name=" + name + ", Email=" + email + ", Phone=" + phoneNumber + "]";
    }
}
