package java.main.LibraryManagementSystem.BookManagement;

import java.main.LibraryManagementSystem.BranchManagement.Branch;
import java.util.*;

public class LibraryInventory {
   private Map<String, Branch> branches;

    public LibraryInventory() {
         this.branches = new HashMap<>();
    }

    public void addBranch(Branch branch) {
        System.out.println("Branch " + branch.getBranchName() + " added to library system.");
        branches.put(branch.getBranchName(), branch);
    }

    public void removeBranch(String branchName) {
        System.out.println("Branch " + branches.get(branchName + " removed to library system."));
        branches.remove(branches.get(branchName));
    }

    public Branch getBranch(String branchName) {
        return branches.get(branchName);
    }

    public void addUpdateBook(Book book, String branchName) {
        Branch branch = branches.get(branchName);
       if (branch != null) {
           branch.addUpdateBook(book);
           return;
       }
        System.out.println("Branch " + branchName + " not found.");
    }

    public void removeBook(String isbn, String branchName) {
        Branch branch = branches.get(branchName);
        if (branch != null) {
           branch.removeBook(isbn);
        }
        System.out.println("Book not found in branch " + branchName);
    }

    public void transferBook(String isbn, String fromBranch, String toBranch, int count){
        Branch fromBr = branches.get(fromBranch);
        if (fromBr != null && fromBr.getBook(isbn) != null) {
            Book book = fromBr.getBook(isbn);
            if(book.getCopiesAvailable() >= count) {
                fromBr.removeBooksByCount(isbn, count);
            }
            Branch toBr = branches.get(toBranch);
            if (toBr != null) {
                Book bookToTransfer = toBr.getBook(isbn);
                if(bookToTransfer == null){
                    Book newbook = new Book(book.getTitle(), book.getAuthor(), book.getIsbn(),
                            book.getPublishYear(), count, toBr);
                    toBr.addUpdateBook(newbook);
                } else {
                    toBr.addBooksByCount(isbn, count);
                }
            }
        }
    }

    public void findBook(String query){
        for(Branch b : branches.values()){
            b.findBook(query);
        }
    }

    public void displayInventory(){
        for(Branch b : branches.values()){
            System.out.println("Branch: " + b.getBranchName());
            for(Book book : b.getAllBooks()){
                System.out.println(book.toString());
            }
        }
    }

    public Branch getBranches(){
        for(Branch b : branches.values()){
            return b;
        }
        return  null;
    }
}
