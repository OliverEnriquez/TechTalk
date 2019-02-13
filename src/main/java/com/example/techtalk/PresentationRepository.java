package com.example.techtalk;

import com.example.techtalk.domain.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    @Query("SELECT COUNT(p) FROM Presentation p")
    Long getCountPresentations();

}
