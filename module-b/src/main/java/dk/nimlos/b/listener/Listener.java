package dk.nimlos.b.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "moduleB", groupId = "foo")
	public void listenGroupFoo(String message) {
		kafkaTemplate.send("moduleA", "response");
	}

}
