package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "showtime", schema = "jsf-project-db", catalog = "")
public class ShowtimeEntity {
    private int id;
    private String movieName;
    private String showTime;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "show_time")
    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowtimeEntity that = (ShowtimeEntity) o;
        return id == that.id &&
                Objects.equals(movieName, that.movieName) &&
                Objects.equals(showTime, that.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, showTime);
    }
}
