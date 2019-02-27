package com.example.techtalk;

import com.example.techtalk.domain.Review;
import com.example.techtalk.dto.PrestReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {





    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.idPresentation = :idPresentation")
    Double avgRating(@Param("idPresentation") Long idPresentation);

    @Query("SELECT r.id, r.idPresentation, r.rating, r.comment, r.user FROM Review r WHERE r.idPresentation = :idPresentation")
    List<Review> getReviewByPresentationId(@Param("idPresentation") Long idPresentation);




}
