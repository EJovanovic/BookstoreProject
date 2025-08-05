package Projekat;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Book testing

        Book book=new Book("Stranger","Jk.Rowling","4515",500.0,Genre.AUTOBIOGRAPHY,455,"Stranger in the house");
        Book bookOne=new Book("Miriam","Philips Pk",1250.0,"7888",Genre.HORROR);
        System.out.println(book);
        System.out.println(book.isAvailable());

        System.out.println(book.reduceStock(40));
        System.out.println(book.addRating(6));//ovo treba da vrati false jer ocena nije u opsegu

        book.addRating(5);
        book.addRating(4);//ratings nemam u konstruktoru jer pri pravljenju objekta ja ne znam ocene, dodajem naknadno
        book.addRating(3);
        System.out.println("Average rating is: " + book.getAverageRating());//pozivam metodu,ovde mi ne treba petlja jer je vec imam u metodi

        bookOne.addComments("nice book");
        bookOne.addComments("The plot twist in unreal");
        bookOne.addComments(null);//ovde treba da vrati da komentar ne moze biti nula
        for(String comment:bookOne.getComments()){//mora petlja ovde jer imam listu komentara
            System.out.println(comment);

            book.addComments("Beautiful written");
            book.addComments("not my thing");
            book.addComments("really sad book");
           book.showComments();
           int numberOfComments=book.numberOfComments();
            System.out.println("Number of comments is: " + numberOfComments);

            book.applyDiscount(10);
            System.out.println(book.getPrice());

            System.out.println(bookOne.isCommentPresent("nice book"));//treba da vrati true

            //Test Bookstore
            List<Book> myBookstore=new ArrayList<>();
            myBookstore.add(bookOne);
            myBookstore.add(book);
          Bookstore bookstore=new Bookstore(myBookstore);
          bookstore.printAllBooks();//pozivam metodu koju sam napravila u klasi bookstore

            Book book2=new Book("title1","Author1",400.0,"45878",Genre.COMEDY);
            bookstore.addBook(book2);
            bookstore.printAllBooks();

            bookstore.removeBook("45878");
            bookstore.printAllBooks();//provera da li je knjiga uklonjena

           Book found= bookstore.findBookByTitle("Stranger");//posto vraca knjigu, moram da napravim promenljivu da bih je sacuvala za kasnije
           if(found!=null){
               System.out.println("Book is found : " + found.getTitle());
           }else{
               System.out.println("The books is not found");
           }
           bookstore.numberofBooks();
      Book book3=new Book("Melody","F.Robinson",755.0,"1255",Genre.ROMANCE);
      bookstore.addBook(book3);
            int count= bookstore.countAllBooksByGenre(Genre.ROMANCE);//ovde je bitno paziti na redosled, prvo dodajem knjige pa onda pozivam metodu,zato mi nije radio main
            System.out.println("Books that belong to genre romance are:" + count);
            System.out.println("Count of all books in the genre horror is:" + count);

            Book book4=new Book("My family","Tomas Edinburg",4555.0,"8999",Genre.ROMANCE);
            bookstore.addBook(book4);
            double average= bookstore.averagePriceByGenre(Genre.ROMANCE);//ovde moram da pazim jer sam mu dala prvo vrednost int, a u metodi mi je double i onda se crveni
            System.out.println("Average price is: " + average);

            Book book5=new Book("Minus and plus","author1",788.0,"7777",Genre.COMEDY);
            Book book6=new Book("Plus and minus","author1",888.0,"8788",Genre.BIOGRAPHY);
            bookstore.addBook(book5);
            bookstore.addBook(book6);
            int author=bookstore.numberOfBooksByAuthor("author1");
            System.out.println("Number of books by this author is: " + author);
            Book itIsFound=bookstore.findBookByIsbn("7777");
            System.out.println("Book with given isbn is: " + itIsFound);

            System.out.println(bookstore.ifBookExists("7777"));
            System.out.println(bookstore.changeOfPrice("8788",850.0));

            bookstore.showBooksByAuthor("author1");//treba da vrati dve knjige
            bookstore.showBooksByAuthor("author2");//ovde treba da izbaci da nema tog autora

            Book mostExpensive=bookstore.findMostExpensive();
            System.out.println(mostExpensive);










        }
    }
    }



