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
    CommandLineRunner initDataBase(PresentationRepository repository) {
        return arg -> {
            System.out.println("Preloading: " + repository.save(new Presentation("Jnuit Test", "28/03/2019", "Oliver Enriquez", "Test", 0.0)));
            System.out.println("Preloading: " + repository.save(new Presentation("Git", "29/03/2019", "Oliver Enriquez", "Test", 0.0 )));
        };
    }
}
