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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PresentationRepositoryTest {

    @Autowired
    PresentationRepository presentationRepository;

    @Autowired
    ReviewRepository reviewRepository;

    private Presentation junitTest;

    @Before
    public void setup() {
        junitTest = new Presentation("Junit Test", "08/03/2019", "Oliver Enriquez", "THis a Junit Test presentation", 0.0);
    }

    @Test
    public void getAllPresentation() {
        junitTest = presentationRepository.save(junitTest);
        List<Presentation> actual = presentationRepository.findAll();
        presentationRepository.getUpdateAvg(3.0,(long) 1);
        actual = presentationRepository.findAll();
        assertTrue(getPresentation(actual, junitTest.getTitle()));

    }

    private boolean getPresentation(List<Presentation> list, String expected) {
        for (Presentation element : list) {
            if(expected.equalsIgnoreCase(element.getTitle())) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void saveJunitTestAndFindById() {
        junitTest = presentationRepository.save(junitTest);
        assertThat(presentationRepository.findOne(junitTest.getId()));
    }

//    @Test
//    public void updateAvgRating() {
//        Long idPresentation = (long) 0;
//        junitTest = presentationRepository.save(junitTest);
//        idPresentation = junitTest.getId();
//        Review firstReview = new Review(idPresentation, "Nice presentation!", 5, "Oliver Enriquez");
//        Review secondfirstReview = new Review(idPresentation, "Bad presentation!", 1, "Jon Snow");
//        reviewRepository.save(firstReview);
//        reviewRepository.save(secondfirstReview);
//        Double avgPresentation = reviewRepository.avgRating(idPresentation);
//        presentationRepository.getUpdateAvg(3.0, (long)1);
//        System.out.println(presentationRepository.findOne(idPresentation).getAvgRating());
//        junitTest= presentationRepository.findOne(idPresentation);
//        int avgExpected = (firstReview.getRating() + secondfirstReview.getRating())/2;
//        assertEquals(String.valueOf(avgExpected), junitTest.getAvgRating().toString());
//    }



}
