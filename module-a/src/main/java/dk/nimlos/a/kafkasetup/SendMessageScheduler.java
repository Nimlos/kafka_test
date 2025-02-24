package dk.nimlos.a.kafkasetup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMessageScheduler {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Scheduled(fixedDelay = 5000)
	public void sendMessage() {
		String msg = "Hallo world!";
		log.info("Sending message: {}", msg);
		kafkaTemplate.send("baeldung", msg);
	}

}
