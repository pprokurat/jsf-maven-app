package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "screening_seat", schema = "jsf-project-db")
public class ScreeningSeatEntity {

    @Id
    @Column(name = "screening_seat_id", nullable = false)
    private int screeningSeatId;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private ScreeningEntity screeningId;

    @ManyToOne
    @JoinColumn(name  ="room_seat_id", nullable = false)
    private RoomSeatEntity roomSeatId;

    @ManyToOne
    @JoinColumn(name = "screening_seat_status", nullable = false)
    private SeatStatusDictionaryEntity screeningSeatStatus;

    @Basic
    @Column(name = "reservation_id", nullable = true)
    private Integer reservationId;


    public int getScreeningSeatId() {
        return screeningSeatId;
    }

    public void setScreeningSeatId(int screeningSeatId) {
        this.screeningSeatId = screeningSeatId;
    }


    public ScreeningEntity getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(ScreeningEntity screeningId) {
        this.screeningId = screeningId;
    }


    public RoomSeatEntity getRoomSeatId() {
        return roomSeatId;
    }

    public void setRoomSeatId(RoomSeatEntity roomSeatId) {
        this.roomSeatId = roomSeatId;
    }

    public SeatStatusDictionaryEntity getScreeningSeatStatus() {
        return screeningSeatStatus;
    }

    public void setScreeningSeatStatus(SeatStatusDictionaryEntity screeningSeatStatus) {
        this.screeningSeatStatus = screeningSeatStatus;
    }


    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningSeatEntity that = (ScreeningSeatEntity) o;
        return screeningSeatId == that.screeningSeatId &&
                screeningId == that.screeningId &&
                roomSeatId == that.roomSeatId &&
                screeningSeatStatus == that.screeningSeatStatus &&
                Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screeningSeatId, screeningId, roomSeatId, screeningSeatStatus, reservationId);
    }
}
