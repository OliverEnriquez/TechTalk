package com.example.techtalk.service;

import com.example.techtalk.dal.TechTalkDao;
import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import com.example.techtalk.dto.PrestReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechTalkService {

    @Autowired
    private TechTalkDao techTalkDao;

    public List<Presentation> getPresentations() {
        return techTalkDao.getPresentations();
    }

    public Long getCountPresentation() {
        return techTalkDao.getCountPresentations();
    }

    public void addPresentation(Presentation presentation) {
        techTalkDao.addPresentation(presentation);
    }

    public List<Review> getReviews() {
        return techTalkDao.getReviews();
    }

    public List<Review> getReviewByPresentationId(Long id) {
        return techTalkDao.getReviewByPresentationId(id);
    }

    public void addReview(Review review) {
        techTalkDao.addReview(review);
    }


//    public List<PrestReviewDto> getReviewsPresentations(Long id) {
//        return techTalkDao.getReviewsPresentations(id);
//    }



}
