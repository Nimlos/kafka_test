package dk.nimlos.communication.kafkasetup;

import dk.nimlos.common.utils.StopWatch;
import dk.nimlos.communication.websocket.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {

	private final ResponseHandler responseHandler;

	@KafkaListener(topics = "communicationModule", groupId = "foo")
	public void listenGroupFoo(String message) {
		responseHandler.sendResponse();
	}
}
