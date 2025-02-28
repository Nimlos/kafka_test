package dk.nimlos.communication.websocket.config;

import dk.nimlos.communication.websocket.WebSocketHandler;
import dk.nimlos.communication.websocket.WebSocketHandlerJacksonTest;
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

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/")
				.setAllowedOrigins("*");  // adjust origins as needed
		registry.addHandler(webSocketHandlerJacksonTest, "/jackson")
				.setAllowedOrigins("*");  // adjust origins as needed
	}

}
