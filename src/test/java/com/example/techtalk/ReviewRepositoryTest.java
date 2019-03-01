package com.example.techtalk;

import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    PresentationRepository presentationRepository;

    private Presentation docker;
    private Review fistReview;
    private Review secondReview;

    @Before
    public void setup() {
        docker = new Presentation("Docker", "08/03/1990", "Oliver Enriquez", "This a intro", 0.0);
        presentationRepository.save(docker);
        fistReview = new Review(docker.getId(), "Nice!", 5, "Jon Snow");
        secondReview = new Review(docker.getId(), "Pff", 1, "Goku");
    }

    @Test
    public void saveReviewAndGetAllReviews() {
        reviewRepository.save(fistReview);
        reviewRepository.save(secondReview);
        List<Review> actual = reviewRepository.findAll();
        assertTrue(getReviews(actual, "Nice!"));

    }

    private boolean getReviews(List<Review> list, String expected) {
        for (Review element : list) {
            if(expected.equalsIgnoreCase(element.getComment())) {
                return true;
            }
        }

        return false;
    }
}
