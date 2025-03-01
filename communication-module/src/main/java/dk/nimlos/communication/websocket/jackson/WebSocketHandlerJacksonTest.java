package dk.nimlos.communication.websocket.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.nimlos.common.messages.FrontEndMessage;
import dk.nimlos.common.messages.messages.MessageA;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
@RequiredArgsConstructor
public class WebSocketHandlerJacksonTest extends TextWebSocketHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		try {
			FrontEndMessage frontEndMessage = objectMapper.readValue(message.getPayload(), FrontEndMessage.class);

		} catch (Exception e) {
			sendWrongFormatMessage(session);
		}
		System.out.println("Her emil");

	}

	private void sendWrongFormatMessage(WebSocketSession session) throws IOException {
		MessageA messageA = new MessageA();
		messageA.setText("Wrong format");
		FrontEndMessage frontEndMessage = new FrontEndMessage();
		frontEndMessage.setMessageData(messageA);
		frontEndMessage.setMessageName("Wrong format");
		String jsonMessage = objectMapper.writeValueAsString(frontEndMessage);
		TextMessage textMessage = new TextMessage(jsonMessage);
		session.sendMessage(textMessage);
	}

}
