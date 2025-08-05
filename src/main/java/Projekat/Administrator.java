package Projekat;

public class Administrator extends User implements Manageable{//nasledjuje usera i implementira njegove apstraktne metode
    private Bookstore bookstore;

    public Administrator(String username, String password, Bookstore bookstore) {
        super(username, password);
        this.bookstore = bookstore;

    }

    @Override
    public void showMenu() {
        System.out.println("Add a book ");
        System.out.println("Remove a book");
        System.out.println("Show all books");

    }

    @Override
    public void loggIn() {
        System.out.println("Administrator: " + getUsername() + "is logged in");

    }

    @Override
    public void loggOut() {
        System.out.println("Administrator: " + getUsername() + "is logged out");

    }

    @Override
    public void addBook(Book book) {
        bookstore.addBook(book);
        System.out.println("Book is added");
    }

    @Override
    public void removeBook(String title) {
        bookstore.removeBook(title);
        System.out.println("Book is removed");


    }

    @Override
    public void showAllBooks() {

        }

        }









