package dk.nimlos.communication.websocket.stomp.config;

import java.security.Principal;
import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {
	@Override
	protected Principal determineUser(ServerHttpRequest request,
			WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		// Return a custom principal, e.g., based on a cookie, URL parameter, etc.
		return new Principal() {
			@Override
			public String getName() {
				return "customUserId";  // Replace with your custom logic
			}
		};
	}
}