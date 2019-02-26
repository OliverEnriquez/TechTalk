package com.example.techtalk.dto;

public class PrestReviewDto {

    private String title;
    private String presenter;
    private Integer rating;
    private String review;

    protected PrestReviewDto() {
    }

    public PrestReviewDto(String title, String presenter, Integer rating, String review) {
        this.title = title;
        this.presenter = presenter;
        this.rating = rating;
        this.review = review;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
