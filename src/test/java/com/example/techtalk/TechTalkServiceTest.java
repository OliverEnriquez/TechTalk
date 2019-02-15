package com.example.techtalk;

import com.example.techtalk.dal.TechTalkDao;
import com.example.techtalk.domain.Presentation;
import com.example.techtalk.service.TechTalkService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TechTalkServiceTest {



    private TechTalkService techTalkService;
    private TechTalkDao techTalkDao;

    @Autowired
    PresentationRepository presentationRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Before
    public void setup() {

        techTalkDao = new TechTalkDao(presentationRepository);
        techTalkService = new TechTalkService();
    }


    @Test
    public void getFirstTitlePresentTest() {
        Presentation junit = new  Presentation("Junit Test", "15/02/2019", "Oliver Enriquez", "Test");
        Presentation git = new  Presentation("git", "23/02/2019", "Oliver Enriquez", "This a intro");
        entityManager.persist(junit);
        entityManager.persist(git);
        entityManager.flush();
        List<Presentation> actual = presentationRepository.findAll();
        assertEquals("Junit Test", actual.get(0).getTitle());
    }
}
