package dk.nimlos.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"dk.nimlos.a", "dk.nimlos.common"})
public class A {
    public static void main(String[] args) {
        SpringApplication.run(A.class, args);
    }
}