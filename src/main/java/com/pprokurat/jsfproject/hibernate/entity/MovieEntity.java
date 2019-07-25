package com.pprokurat.jsfproject.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "jsf-project-db", catalog = "")
public class MovieEntity {
    private int id;
    private String movieName;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return id == that.id &&
                Objects.equals(movieName, that.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName);
    }
}
