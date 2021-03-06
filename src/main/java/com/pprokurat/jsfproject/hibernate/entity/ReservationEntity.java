package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "jsf-project-db")
public class ReservationEntity {
    private int reservationId;
    private String email;
    private String name;
    private String phoneNumber;
    private int regularTicketsNumber;
    private int reducedTicketsNumber;
    private int price;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 100)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "regular_tickets_number", nullable = false)
    public int getRegularTicketsNumber() {
        return regularTicketsNumber;
    }

    public void setRegularTicketsNumber(int regularTicketsNumber) {
        this.regularTicketsNumber = regularTicketsNumber;
    }

    @Basic
    @Column(name = "reduced_tickets_number", nullable = false)
    public int getReducedTicketsNumber() {
        return reducedTicketsNumber;
    }

    public void setReducedTicketsNumber(int reducedTicketsNumber) {
        this.reducedTicketsNumber = reducedTicketsNumber;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return reservationId == that.reservationId &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, email);
    }

}
