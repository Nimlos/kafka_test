package dk.nimlos.communication.websocket.protowebsocket;


import dk.nimlos.common.protomessages.FrontendMessage.FrontEndMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.google.protobuf.util.JsonFormat;

@Service
@RequiredArgsConstructor
public class WebSocketHandlerProtoTest extends TextWebSocketHandler {





	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		FrontEndMessage.Builder builder = FrontEndMessage.newBuilder();
		try {
			// Parse the JSON into the FrontEndMessage builder.
			JsonFormat.parser().ignoringUnknownFields().merge(message.getPayload(), builder);
			FrontEndMessage feMessage = builder.build();

			// Use the parsed message.
			System.out.println("Parsed FrontEndMessage: " + feMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
