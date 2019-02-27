package com.example.techtalk.dal;

import com.example.techtalk.PresentationRepository;
import com.example.techtalk.ReviewRepository;
import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import com.example.techtalk.dto.PrestReviewDto;
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
        presentationRepository.save(new Presentation(presentation.getTitle(), presentation.getDate(), presentation.getPresenter(), presentation.getIntro(), 0.0));
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewByPresentationId(Long id) {
        return reviewRepository.getReviewByPresentationId(id);
    }

    public void addReview(Review review) {
        reviewRepository.save(new Review(review.getIdPresentation(), review.getComment(), review.getRating(),review.getUser()));
        presentationRepository.getUpdateAvg(reviewRepository.avgRating(review.getIdPresentation()), review.getIdPresentation());
    }

    public Double getAvgRating(Integer id) {
       return reviewRepository.avgRating((long) 2);
    }

//    public List<PrestReviewDto> getReviewsPresentations(Long id) {
//        return presentationRepository.getReviewsPresentations((long)2);
//    }


}
