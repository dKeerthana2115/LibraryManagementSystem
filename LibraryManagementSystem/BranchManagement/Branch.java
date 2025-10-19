package java.main.LibraryManagementSystem.BranchManagement;

import java.main.LibraryManagementSystem.BookManagement.Book;
import java.util.*;

public class Branch {
    private String branchName;
    private String address;
    private Map<String, Book> inventory;

    public Branch(String branchName, String address) {
        this.branchName = branchName;
        this.address = address;
        this.inventory = new HashMap<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public String getAddress() {
        return address;
    }

    public void addUpdateBook(Book book) {
        for(Book b : inventory.values()){
            if(b.getIsbn().equals(book.getIsbn())){
               int totCopies = b.getCopiesAvailable() + book.getCopiesAvailable();
               Book updatedBook = new Book(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublishYear(), totCopies, this);
               inventory.put(b.getIsbn(), updatedBook);
               System.out.println("Updated book: " + updatedBook.getIsbn());
               return;
            }
        }
        inventory.put(book.getIsbn(), book);
        System.out.println("Added new book: " + book.getIsbn());
    }

    public void removeBook(String isbn) {
        System.out.println("Removed book: " + isbn);
        inventory.remove(isbn);
    }

    public void removeBooksByCount(String isbn, int count){
        Book b = inventory.get(isbn);
        if(b != null){
            int remainingCopies = b.getCopiesAvailable() - count;
            if(remainingCopies <= 0){
                inventory.remove(isbn);
                System.out.println("All copies of book " + isbn + " removed.");
            } else {
                Book updatedBook = new Book(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublishYear(), remainingCopies, this);
                inventory.put(isbn, updatedBook);
                System.out.println("Updated book " + isbn + " to have " + remainingCopies + " copies.");
            }
        } else {
            System.out.println("Book " + isbn + " not found in inventory.");
        }
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return inventory.values();
    }

    public void addBooksByCount(String isbn, int count) {
        Book b = inventory.get(isbn);
        if(b != null){
            int totalCopies = b.getCopiesAvailable() + count;
            Book updatedBook = new Book(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublishYear(), totalCopies, this);
            inventory.put(isbn, updatedBook);
            System.out.println("Updated book " + isbn + " to have " + totalCopies + " copies.");
        } else {
            System.out.println("Book " + isbn + " not found in inventory.");
        }
    }

    public List<Book> findBook(String query) {
        List<Book> results = new ArrayList<>();
        for (Book b : inventory.values()) {
            if (b.getTitle().equalsIgnoreCase(query)
                    || b.getAuthor().equalsIgnoreCase(query)
                    || b.getIsbn().equals(query)) {
                results.add(b);
            }
        }
        return results;
    }

}
