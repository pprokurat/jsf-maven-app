package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "jsf-project-db")
public class ReservationEntity {
    private int reservationId;
    private String email;

    @Id
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