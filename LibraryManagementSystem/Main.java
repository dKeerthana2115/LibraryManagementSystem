package java.main.LibraryManagementSystem;

import java.main.LibraryManagementSystem.BookManagement.Book;
import java.main.LibraryManagementSystem.BookManagement.LibraryInventory;
import java.main.LibraryManagementSystem.BranchManagement.Branch;
import java.main.LibraryManagementSystem.PatronManagement.Patron;
import java.main.LibraryManagementSystem.PatronManagement.PatronRecords;
import java.main.LibraryManagementSystem.Reservation.ReservationSystem;

import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // ======= Setup Library =======
            LibraryInventory libraryInventory = new LibraryInventory();
            PatronRecords patronRecords = new PatronRecords();

            Branch centralBranch = new Branch("Central Library", "123 Main St");
            Branch westBranch = new Branch("West Library", "456 West St");

            libraryInventory.addBranch(centralBranch);
            libraryInventory.addBranch(westBranch);

            // ======= Add Books =======
            Book b1 = new Book("Clean Code", "Robert C. Martin", "ISBN001", "2008", 2, centralBranch);
            Book b2 = new Book("Effective Java", "Joshua Bloch", "ISBN002", "2018", 1, centralBranch);
            Book b3 = new Book("The Pragmatic Programmer", "Andrew Hunt", "ISBN003", "1999", 0, westBranch);
            Book b4 = new Book("Effective Java", "Joshua Bloch", "ISBN002", "2018", 1, centralBranch);

            libraryInventory.addUpdateBook(b1, "Central");
            libraryInventory.addUpdateBook(b2, "Central");
            libraryInventory.addUpdateBook(b3, "West");
            libraryInventory.addUpdateBook(b4, "West");

            // ======= Add Patrons =======
            Patron dev = new Patron("Dev", "P001", "dev@gmail.com", "12345", 3);
            Patron moksh = new Patron("Moksh", "P002", "moksh23@gmail.com", "67890", 3);

            patronRecords.addPatron(dev);
            patronRecords.addPatron(moksh);

            // ======= Setup Systems =======
            ReservationSystem reservationSystem = new ReservationSystem();
            List<Book> allBooks = new ArrayList<>();
            allBooks.add(b1);
            allBooks.add(b2);
            allBooks.add(b3);
            allBooks.add(b4);

            // ===== Borrow Books =====
            System.out.println("\n--- Borrowing Books ---");
            dev.borrowBook(b1);  // Alice borrows Clean Code

            // Attempt to borrow unavailable book
            if (b3.getCopiesAvailable() == 0) {
                System.out.println("Book '" + b3.getTitle() + "' is unavailable. Alice will reserve it.");
                reservationSystem.reserveBook(b3, dev);
            }

            moksh.borrowBook(b2);

            // ===== Return Book =====
            System.out.println("\n--- Returning Books ---");
            dev.removeBook(b1);          // Alice returns Clean Code
            reservationSystem.notifyNextPatron(b1);

            // ===== Display Inventory =====
            System.out.println("\n--- Library Inventory ---");
            libraryInventory.displayInventory();
        }
    }


