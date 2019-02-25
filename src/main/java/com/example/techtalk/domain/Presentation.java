package com.example.techtalk.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Presentation {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private String date;
    private String presenter;
    private String intro;

    @OneToMany(targetEntity = Review.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    protected Presentation() {
    }


    public Presentation(String title, String date, String presenter, String intro) {
        this.title = title;
        this.date = date;
        this.presenter = presenter;
        this.intro = intro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
