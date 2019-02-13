package com.example.techtalk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Presentation {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private String date;
    private String presenter;
    private String intro;

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
}
