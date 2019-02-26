package com.example.techtalk;

import com.example.techtalk.domain.Presentation;
import com.example.techtalk.dto.PrestReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    @Query("SELECT COUNT(p) FROM Presentation p")
    Long getCountPresentations();

//    @Query("SELECT p.title, r.rating FROM Presentation p JOIN p.reviews WHERE p.id = :idPresentation")
//    List<PrestReviewDto> geteviewsPresentations(@Param("idPresentation") Integer idPresentation);

    @Transactional
    @Modifying
    @Query("UPDATE Presentation p SET p.avgRating = :avgRating WHERE p.id = :id")
    void getUpdateAvg(@Param("avgRating") Double avgRating, @Param("id") Long id);





}
