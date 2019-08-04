package com.pprokurat.jsfproject.web.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

    private String email;

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
