package Projekat;

import java.util.Objects;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {//kada pravimo novog korisnika odmah postavljamo
        if (username == null || username.trim().isEmpty()){//trim uklanja sve znakove i razmake
            System.out.println("Warning:Username field is empty,please try again.");
        this.username = "Unknown user";
    }else {
            this.username = username;
        }
        if(password==null || password.trim().isEmpty()){
            System.out.println("Warning: Password field is empty,please try again. ");
            this.password=" ";
        }else {
            this.password = password;
        }
    }
    public String getUsername() {
        return username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {//lozinka moze da se menja i zato dodajemo setPassword
        this.password = password;
    }
    public abstract void showMenu();//svaki tip korisnika ce imati svoj menu zato je apstraktan
    //na ovaj nacin obavezujem podklase da implementiraju ovu metodu
    public abstract void loggIn();
    public abstract void loggOut();//ovo ce implementirati kasnije pored administratora i druge klase koje nasledjuju


    @Override
    public String toString() {
        return "User: " + username + "password" + password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);//proveravam da li postoje dva usera sa istim korisnickim
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}




