package java.main.LibraryManagementSystem.Reservation;

import java.main.LibraryManagementSystem.BookManagement.Book;
import java.main.LibraryManagementSystem.PatronManagement.Patron;
import java.util.*;

public class ReservationSystem {
    private Map<String, List<Patron>> reservationMap;

    public ReservationSystem() {
        reservationMap = new HashMap<>();
    }

    public void reserveBook(Book book, Patron patron){
        if(book.getCopiesAvailable() > 0){
            System.out.println("Book is available. No need to reserve. You can check out.");
            return;
        }

        List<Patron> waiting = reservationMap.getOrDefault(book.getIsbn(), new ArrayList<>());
        if (waiting.contains(patron)) {
            System.out.println(patron.getName() + " has already reserved this book.");
            return;
        }
        waiting.add(patron);
        reservationMap.put(book.getIsbn(), waiting);
    }

    public void notifyNextPatron(Book book) {
        List<Patron> waiting = reservationMap.get(book.getIsbn());
        if (waiting == null || waiting.isEmpty()) {
            return;
        }

        Patron nextPatron = waiting.remove(0);  // first in list
        System.out.println("Book '" + book.getTitle() + "' is now available for " + nextPatron.getName() + ".");
    }
}
