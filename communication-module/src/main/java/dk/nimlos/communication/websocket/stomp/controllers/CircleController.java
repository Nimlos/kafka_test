package dk.nimlos.communication.websocket.stomp.controllers;

import dk.nimlos.communication.websocket.stomp.request.Coordinates;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CircleController {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@MessageMapping({"/coordinates"})
	public void greeting(Coordinates message, Principal principal) {
		System.out.println("User ID: " + principal.getName());
		kafkaTemplate.send("moduleA", "request");
	}
}
