package fr.wildcodeschool.blablawild;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TripModel {
    private String firstname;
    private String lastname;
    private Date date;
    private int price;

    public TripModel(){
        this.firstname = "firstname";
        this.lastname = "lastname";
        this.price = 0;
    }

    public TripModel(String firstname, String lastname, Date date, int price){
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.price = price;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd/MM/yyyy h:m a");
        return fmtOut.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
