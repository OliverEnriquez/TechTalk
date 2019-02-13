package com.example.techtalk.service;

import com.example.techtalk.dal.TechTalkDao;
import com.example.techtalk.domain.Presentation;
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



}
