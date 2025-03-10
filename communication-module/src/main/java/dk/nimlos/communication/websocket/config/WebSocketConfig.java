package dk.nimlos.communication.websocket.config;

import dk.nimlos.communication.websocket.defaultwebsocket.WebSocketHandler;
import dk.nimlos.communication.websocket.jackson.WebSocketHandlerJacksonTest;
import dk.nimlos.communication.websocket.protowebsocket.WebSocketHandlerProtoTest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
@Service
public class WebSocketConfig implements WebSocketConfigurer {

	private final WebSocketHandler webSocketHandler;
	private final WebSocketHandlerJacksonTest webSocketHandlerJacksonTest;
	private final WebSocketHandlerProtoTest webSocketHandlerProtoTest;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/")
				.setAllowedOrigins("*");  // adjust origins as needed
		registry.addHandler(webSocketHandlerJacksonTest, "/jackson")
				.setAllowedOrigins("*");  // adjust origins as needed
		registry.addHandler(webSocketHandlerProtoTest, "/proto")
				.setAllowedOrigins("*");  // adjust origins as needed
	}

}
