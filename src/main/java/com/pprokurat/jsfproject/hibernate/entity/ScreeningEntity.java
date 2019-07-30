package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "screening", schema = "jsf-project-db")
public class ScreeningEntity {

    @Id
    @Column(name = "screening_id", nullable = false)
    private int screeningId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "time", nullable = false)
    private Time time;


    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }


    public MovieEntity getMovieEntity() { return movieEntity; }

    public void setMovieEntity(MovieEntity movieEntity) { this.movieEntity = movieEntity; }


    public RoomEntity getRoomEntity() { return roomEntity; }

    public void setRoomEntity(RoomEntity roomEntity) { this.roomEntity = roomEntity; }


    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }


    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningEntity that = (ScreeningEntity) o;
        return screeningId == that.screeningId &&
                Objects.equals(movieEntity, that.movieEntity) &&
                Objects.equals(roomEntity, that.roomEntity) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screeningId, movieEntity, roomEntity, date, time);
    }
}