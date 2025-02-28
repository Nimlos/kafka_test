package dk.nimlos.communication.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.nimlos.common.messages.FrontEndMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
@RequiredArgsConstructor
public class WebSocketHandlerJacksonTest extends TextWebSocketHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		FrontEndMessage frontEndMessage = objectMapper.readValue(message.getPayload(), FrontEndMessage.class);
		System.out.println("Her emil");

	}

}
