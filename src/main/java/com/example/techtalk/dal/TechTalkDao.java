package com.example.techtalk.dal;

import com.example.techtalk.PresentationRepository;
import com.example.techtalk.domain.Presentation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechTalkDao {

    private final PresentationRepository presentationRepository;

    public TechTalkDao(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
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
}
