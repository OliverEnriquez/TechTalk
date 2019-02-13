package com.example.techtalk;
import com.example.techtalk.domain.Presentation;
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
            System.out.println("Preloading: " + repository.save(new Presentation("Jnuit Test", "15/02/2019", "Oliver Enriquez", "Test")));
            System.out.println("Preloading: " + repository.save(new Presentation("Git", "23/02/2019", "Oliver Enriquez", "Test")));
        };
    }
}
