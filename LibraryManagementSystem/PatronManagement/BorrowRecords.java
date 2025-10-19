package java.main.LibraryManagementSystem.PatronManagement;

import java.main.LibraryManagementSystem.BookManagement.Book;
import java.time.*;

public class BorrowRecords {
    private String patronId;
    private String bookIsbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecords(String patronId, String bookIsbn, LocalDate borrowDate) {
        this.patronId = patronId;
        this.bookIsbn = bookIsbn;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public String getPatronId() {
        return patronId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord [PatronID=" + patronId + ", BookISBN=" + bookIsbn +
                ", BorrowDate=" + borrowDate + ", ReturnDate=" + returnDate + "]";
    }
}
