package dk.nimlos.a.kafkasetup;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionListener {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "session", groupId = "moduleA")
	public void listenGroupFoo(String message) {
		System.out.println("Session from moduleA");
	}
}
