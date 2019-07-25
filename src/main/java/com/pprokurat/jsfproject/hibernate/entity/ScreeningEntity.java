package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "screening", schema = "jsf-project-db", catalog = "")
public class ScreeningEntity {
    private int id;
    private int movieId;
    private int roomId;
    private Date date;
    private Time time;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_ID")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "room_ID")
    public int getRoomId() { return roomId; }

    public void setRoomId(int roomId) { this.roomId = roomId; }

    @Basic
    @Column(name = "date")
    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Basic
    @Column(name = "time")
    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningEntity that = (ScreeningEntity) o;
        return id == that.id &&
                Objects.equals(movieId, that.movieId) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, roomId, date, time);
    }
}
