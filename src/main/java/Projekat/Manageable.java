package Projekat;

public interface Manageable {//kada budem napravila jos klasa, na primer editor moze da implementira
    void addBook(Book book);
    void removeBook(String title);
    void showAllBooks();
}
