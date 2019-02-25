package com.example.techtalk.dal;

import com.example.techtalk.PresentationRepository;
import com.example.techtalk.ReviewRepository;
import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechTalkDao {

    private final PresentationRepository presentationRepository;
    private final ReviewRepository reviewRepository;

    public TechTalkDao(PresentationRepository presentationRepository, ReviewRepository reviewRepository) {
        this.presentationRepository = presentationRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Presentation> getPresentations() {
        return presentationRepository.findAll();
    }

    public Long getCountPresentations() {
        return presentationRepository.getCountPresentations();
    }

    public void addPresentation(Presentation presentation) {
        presentationRepository.save(new Presentation(presentation.getTitle(), presentation.getDate(), presentation.getPresenter(), presentation.getIntro()));
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public void addReview(Review review) {
        reviewRepository.getPresentationsReview();
    }


}
