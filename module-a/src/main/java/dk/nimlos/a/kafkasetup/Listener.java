package dk.nimlos.a.kafkasetup;

import dk.nimlos.common.utils.StopWatch;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "moduleA", groupId = "foo")
	public void listenGroupFoo(String message) {
		if (message.equals("response")) {
			kafkaTemplate.send("communicationModule", message);
		} else {
			kafkaTemplate.send("moduleB", message);
		}

	}
}
