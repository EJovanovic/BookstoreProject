package Projekat;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {// ovde cu da dodam ratings, comments, stock, desription, za sad ovo jer mi je lakse da testiram u mainu
    private String title;
    private String author;
    private String isbn;
    private double price;
    private Genre genre;
    private List<Integer> ratings;
    private List<String> comments;
    private int stock;
    private String description;

    public Book(String title, String author, String isbn, double price, Genre genre, int stock, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.genre = genre;
        this.stock = stock;
        this.description = description;
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Book(String title, String author, double price, String isbn, Genre genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.stock = 0;
        this.description = "";
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public Book clone() {
        Book copy = new Book(this.title, this.author, this.isbn, this.price, this.genre, this.stock, this.description);

        copy.ratings = new ArrayList<>(this.ratings);
        copy.comments = new ArrayList<>(this.comments);

        return copy;


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Autor: ").append(author).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("Genre: ").append(genre).append("\n");
        return sb.toString();
    }

    public boolean isAvailable() {
        if (stock > 0) {
            return true;//da li knjige ima na stanju,ako ima vrati true
        }
        return false;
    }

    public boolean reduceStock(int quantity) {

        if (quantity <= stock) {//proveravam da li ima dovoljno knjiga
            stock -= quantity;//ako ima oduzimam trazenu kolicinu
            return true;//uspesno
        } else {
            System.out.println("Not enough books in stock");
            return false;//nije uspelo

        }
    }

    public boolean addRating(int rating) {//mora boolean da bih znala da li je uspesno uradjeno
        if (rating > 0 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            System.out.println("Invalid rating, please enter a number between 1 and 5");
            return false;
        }
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {//prvo proveravam da li ima ocena
            return 0.0;
        }
        int sum = 0;
        for (int rating : ratings) {//iteriram kroz niz
            sum += rating;//sabiram
        }
        return (double) sum / ratings.size();//vracam prosek
    }

    public void addComments(String comment) {
        if (comment != null) {
            comments.add(comment);
        } else {
            System.out.println("Comment can not be empty");
        }
    }

    public void showComments() {
        if (comments.isEmpty()) {
            System.out.println("No comments yet");
        } else {
            for (String comment : comments) {
                System.out.println(comment);
            }
        }
    }

    public int numberOfComments() {
        return comments.size();
    }

    public double applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price = price - (price * percentage / 100);
        } else {
            System.out.println("Invalid discount percentage");

        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    public boolean isCommentPresent(String comment){
        if(comment==null){
            return false;
        }return comments.contains(comment);

        }
    }
















