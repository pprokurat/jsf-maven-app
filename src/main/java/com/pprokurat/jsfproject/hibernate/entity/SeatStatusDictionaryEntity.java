package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "seat_status_dictionary", schema = "jsf-project-db")
public class SeatStatusDictionaryEntity {
    private int seatStatusId;
    private String seatStatus;

    @Id
    @Column(name = "seat_status_id", nullable = false)
    public int getSeatStatusId() {
        return seatStatusId;
    }

    public void setSeatStatusId(int seatStatusId) {
        this.seatStatusId = seatStatusId;
    }

    @Basic
    @Column(name = "seat_status", nullable = false, length = 100)
    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatStatusDictionaryEntity that = (SeatStatusDictionaryEntity) o;
        return seatStatusId == that.seatStatusId &&
                Objects.equals(seatStatus, that.seatStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatStatusId, seatStatus);
    }
}
