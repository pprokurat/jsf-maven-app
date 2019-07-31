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
@Table(name = "room_seat", schema = "jsf-project-db")
public class RoomSeatEntity {

    @Id
    @Column(name = "room_seat_id", nullable = false)
    private int roomSeatId;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private RoomEntity roomEntity;

    @Basic
    @Column(name = "row_number", nullable = false)
    private int rowNumber;

    @Basic
    @Column(name = "seat_number", nullable = false)
    private int seatNumber;


    public int getRoomSeatId() {
        return roomSeatId;
    }

    public void setRoomSeatId(int roomSeatId) {
        this.roomSeatId = roomSeatId;
    }


    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }


    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomSeatEntity that = (RoomSeatEntity) o;
        return roomSeatId == that.roomSeatId &&
                roomEntity == that.roomEntity &&
                rowNumber == that.rowNumber &&
                seatNumber == that.seatNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomSeatId, roomEntity, rowNumber, seatNumber);
    }
}
