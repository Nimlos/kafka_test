package dk.nimlos.a.kafkasetup;

import dk.nimlos.common.utils.StopWatch;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMessageScheduler {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final StatisticsHandler statisticsHandler;

	//@Scheduled(fixedDelay = 200)
	public void sendMessage() {
		String msg = UUID.randomUUID().toString();
		StopWatch.startStopWatch(msg);
		kafkaTemplate.send("moduleB", msg);
	}



}
