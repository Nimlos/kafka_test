package dk.nimlos.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class B {
    public static void main(String[] args) {
        SpringApplication.run(B.class, args);
    }
}