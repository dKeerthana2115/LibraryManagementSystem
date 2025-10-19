package java.main.LibraryManagementSystem.PatronManagement;

import java.util.*;

public class PatronRecords {
    private Map<String, Patron> patronMap;

    public PatronRecords() {
        patronMap = new HashMap<>();
    }

    public void addPatron(Patron patron) {
        patronMap.put(patron.getPatronId(), patron);
        System.out.println("Patron with ID " + patron.getPatronId() + " added.");
    }

    public void updatePatron(Patron patron) {
        patronMap.put(patron.getPatronId(), patron);
        System.out.println("Patron with ID " + patron.getPatronId() + " updated.");
    }

    public void removePatron(String patronId) {
        patronMap.remove(patronId);
        System.out.println("Patron with ID " + patronId + " removed.");
    }

    public Patron getPatronId(String patronId) {
        if (patronId == null) return null;
        return patronMap.get(patronId);
    }
}
