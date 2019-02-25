package com.example.techtalk;

import com.example.techtalk.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select rvw.rating,prt.title FROM Review rvw JOIN Presentation prt ON rvw.idPresentation=prt.id")
    Long getPresentationsReview();
}
