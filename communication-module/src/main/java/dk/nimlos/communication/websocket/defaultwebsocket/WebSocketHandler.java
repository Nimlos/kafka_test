package dk.nimlos.communication.websocket.defaultwebsocket;

import dk.nimlos.communication.websocket.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.nimlos.communication.websocket.stomp.request.Coordinates;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private final ResponseHandler responseHandler;
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		responseHandler.setSession(session);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// Deserialize incoming JSON message into Coordinates object
		Coordinates coordinates = objectMapper.readValue(message.getPayload(), Coordinates.class);

		kafkaTemplate.send("moduleA", "request");

	}

}
