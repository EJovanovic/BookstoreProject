package Projekat;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private String ime;
    private List<Book> books;//lista knjiga

    public Bookstore(String ime, List<Book> books) {
        this.ime = ime;
        this.books = books;

    }

    public Bookstore(List<Book> books) {
        this.books = new ArrayList<>();//pravim novu praznu listu
        for (Book book : books) {
            this.books.add(book.clone());//dodajem kopije u svoju listu
        }

    }

    public void addBook(Book book) {
        books.add(book.clone());//dodajem clone
    }


    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The bookstore is empty");
            return;//ako je lista prazna izlazi iz metode
        }
        System.out.println("====all books===");
        for (Book book : books) {
            System.out.println(book);//ova metoda mi je potrebna da bih pozvala u main
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {//ovde je bitno da koristim for petlju kad menjam po odredjenom kriterijumu
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                System.out.println("Book with isbn: " + isbn + "is removed");
                return;//mora biti unutar if bloka
            }
        }
        System.out.println("Book with isbn: " + isbn + "not found");
    }

    public Book findBookByTitle(String title) {//ovde je bolje da vraca Book ako planiram posle da je koristim
        for (Book book : books) {//moze for each jer ne menjam nista, samo citam podatke
            if (book.getTitle().equals(title)) {//poredim sa naslovom koji je prosledjen
                return book;//ako je knjiga pronadjena, vrati je
            }
        }
        return null;//ovo moram da proveravam u mainu


    }

    //Number of books
    public int numberofBooks() {
        return books.size();//samo vrati duzinu liste
    }

    //Count all books by genre
    public int countAllBooksByGenre(Genre genre) {//u sustini meni je potreban samo jedan metod a u mainu prosledjujem zanr koji zelim
        int count = 0;
        for (Book book : books) {//prodji kroz knjige
            if (book.getGenre().equals(genre)) {//uporedi da li je tog zanra
                count++;//saberi ako jeste
            }
        }
        return count;
    }
    //average price of all books in that genre
    public double averagePriceByGenre(Genre genre){
        int count=0;
        int sum=0;
        for(Book book:books){
            if(book.getGenre()==genre){//prvo proveravam da li je knjiga tog zanra
                sum+=book.getPrice();//ako jeste,sabiram cene onih koje pripadaju tom zanru
                count++;//brojim
            }

        }
        if(count==0){//ako nijedna ne pripada tom zanru
            return -1;
        }
        return (double)sum/count;//kastovanje, mogla sam da stavim i double sum pa da nemam kastovanje
    }

    //Count all books by author
    public int numberOfBooksByAuthor(String author){
        int count=0;
        for(Book book:books){//iteriraj
            if(book.getAuthor().equals(author)){//samo poredjenje da li ta knjiga ima prosledjenog autora
                count++;
            }
        }
        return count;
    }


    //search books by isbn
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;//knjiga je pronadjena
            }
        }
        return null;
    }


    //found book if it exists in the bookstore
    public boolean ifBookExists(String isbn) {
        for(Book book:books){
            if(book.getIsbn().equals(isbn)){
                return true;//izlazi odmah iz metode, pronasao je
            }
        }
        return false;//nema nijedne knjige sa tim isbn
    }


    public boolean changeOfPrice(String isbn, double newPrice) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                book.setPrice(newPrice);//ovde koristi setter
                return true;//ako je pronadjena knjiga sa tim isbn ti obavesti da je cena promenjena
            }
        }
            return false;
        }



    public void showBooksByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found by given author");

        }
    }

    public Book findMostExpensive() {
        if (books.isEmpty()) {//mora ova provera da ne bi izbacilo gresku
            return null;//no books in the bookstore
        }
        Book theMostexpensive = books.get(0);//pretpostavljam da je ona na nultom indeksu najskuplja kako bih mogla da poredim
        for (Book book : books) {
            if (book.getPrice() > theMostexpensive.getPrice()) {
                theMostexpensive = book;//nasli smo najskuplju
            }
        }
        return theMostexpensive;
    }

    public void showBooksBelowPrice(double price) {
        boolean found = false;

        for (Book book : books) {
            if (book.getPrice() < price) {
                System.out.println(book);
                found = true;

            }
            if (!found) {
                System.out.println("No books in the bookstore below price");
            }
        }
    }

    public void changeBookAtindex(Book newBook, int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Index is not found");
            return;
        }
        books.set(index, newBook);
        System.out.println("Book at index" + index + " is successfully changed");
    }

            public Book findBookbyIndex(int index) {
                if (index >= 0 && index < books.size()) {//ovde znam koji je indeks i zato mi ne treba petlja
                    return books.get(index);
                } else {
                    System.out.println("Index is out of bounds");
                    return null;

                }
            }
        public void showBookAtIndex (int index) {
            if (index < 0 || index >= books.size()) {
                System.out.println("Invalid index");
                return;
            } else {
                Book book = books.get(index);
                System.out.println(book);
            }
        }
            public void swapBooks(int index1,int index2) {
                if (index1 < 0 || index1 >= books.size() && index2 < 0 || index2 >= books.size()) {
                    System.out.println("One or both index are invalid");
                    return;
                } else {
                    Book book = books.get(index1);
                    books.set(index1, books.get(index2));
                    books.set(index2, book);

                }
            }


        }




























