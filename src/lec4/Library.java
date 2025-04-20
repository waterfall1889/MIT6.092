package lec4;

import java.util.Objects;

public class Library {
    // Add the missing implementation to this class
    static int MAX_SIZE = 10000;
    int currentSize;
    Book[] books = new Book[MAX_SIZE];

    String address;
    static String openingHours;
    public Library() {
        currentSize = 0;
        address = "";
        openingHours = "Libraries are open daily from 9am to 5pm.";
    }

    public Library(String address){
        this.address = address;
        currentSize = 0;
        openingHours = "Libraries are open daily from 9am to 5pm.";
    }

    public void addBook(Book book) {
        books[currentSize] = book;
        currentSize++;
    }

    public static void printOpeningHours() {
        System.out.println(openingHours);
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void printAvailableBooks(){
        for(int i = 0; i < currentSize; i++){
            if(!books[i].borrowed){
                System.out.println(books[i].title);
            }
        }
    }

    public void borrowBook(String bookName) {
        for(int i = 0; i < currentSize; i++){
            if(!Objects.equals(books[i].title, bookName)){
                continue;
            }
            if(!books[i].borrowed){
                books[i].borrowed = true;
                System.out.println("You successfully borrowed "+books[i].title);
                return;
            }
            else{
                System.out.println("Sorry, this book is already borrowed.");
                return;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    public void returnBook(String bookName) {
        for(int i = 0; i < currentSize; i++){
            if(Objects.equals(books[i].title, bookName)){
                books[i].borrowed = false;
                System.out.println("You successfully returned "+books[i].title);
                return;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }


    public static void main(String[] args) {
// Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
// Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
// Print opening hours and the addresses
        System.out.println("lec3.Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("lec3.Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
// Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
// Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
// Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
// Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}