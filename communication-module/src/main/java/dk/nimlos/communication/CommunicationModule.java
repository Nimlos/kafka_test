package dk.nimlos.communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CommunicationModule {
    public static void main(String[] args) {
        SpringApplication.run(CommunicationModule.class, args);
    }
}