package dk.nimlos.b.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

	@KafkaListener(topics = "baeldung", groupId = "foo")
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group foo: " + message);
	}

}
