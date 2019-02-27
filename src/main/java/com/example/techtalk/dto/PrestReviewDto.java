package com.example.techtalk.dto;

public class PrestReviewDto {

    private Long id;
    private String title;
    private String presenter;
    private Integer rating;
    private String comment;


    protected PrestReviewDto() {
    }

    public PrestReviewDto(Long id, String title, String presenter, Integer rating, String comment) {
        this.id = id;
        this.title = title;
        this.presenter = presenter;
        this.rating = rating;
        this.comment = comment;
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

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
