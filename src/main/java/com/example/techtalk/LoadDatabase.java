package com.example.techtalk;
import com.example.techtalk.domain.Presentation;
import com.example.techtalk.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(PresentationRepository repository, ReviewRepository review) {
        return arg -> {
            System.out.println("Preloading: " + repository.save(new Presentation("Jnuit Test", "15/02/2019", "Oliver Enriquez", "Test", 0.0)));
            System.out.println("Preloading: " + repository.save(new Presentation("Git", "23/02/2019", "Oliver Enriquez", "Test", 0.0 )));
            review.save(new Review((long) 2,"Comment", 5, "oenriquez"));

        };
    }
}
