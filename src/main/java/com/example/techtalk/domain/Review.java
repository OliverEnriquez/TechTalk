package com.example.techtalk.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class Review {
    private @Id
    @GeneratedValue
    Long id;

    private Long idPresentation;
    private String comment;
    private Integer rating;
    private String user;


    protected Review() {}

    public Review(Long idPresentation, String comment, Integer rating, String user) {
        this.idPresentation = idPresentation;
        this.comment = comment;
        this.rating = rating;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Long idPresentation) {
        this.idPresentation = idPresentation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
