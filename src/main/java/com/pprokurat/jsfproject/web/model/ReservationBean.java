package com.pprokurat.jsfproject.web.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

    private String email;
    private int columns = 10;

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void makeReservation() {

    }

    public void buyTickets() {

    }
}
