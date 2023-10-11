import java.util.ArrayList;
import java.util.Iterator;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + publicationYear;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn, int publicationYear) {
        Book newBook = new Book(title, author, isbn, publicationYear);
        books.add(newBook);
        System.out.println("Added book: " + newBook);
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.toString().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found matching book: " + book);
            }
        }
    }

    public void removeBookByISBN(String isbn) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Removed book with ISBN " + isbn);
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in the library.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Додавання книг
        library.addBook("Book 1", "Author A", "1234567890", 2020);
        library.addBook("Book 2", "Author B", "9876543210", 2018);
        library.addBook("Another Book", "Author C", "5555555555", 2015);

        // Відображення всіх книг
        library.showAllBooks();

        // Пошук книги за назвою
        library.searchBookByTitle("book");

        // Видалення книги за ISBN
        library.removeBookByISBN("1234567890");

        // Повторний вивід списку книг
        library.showAllBooks();
    }
}
