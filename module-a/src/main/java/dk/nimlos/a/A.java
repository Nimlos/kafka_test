package dk.nimlos.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class A {
    public static void main(String[] args) {
        SpringApplication.run(A.class, args);
    }
}