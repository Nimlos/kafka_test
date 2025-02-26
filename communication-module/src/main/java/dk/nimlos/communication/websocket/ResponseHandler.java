package dk.nimlos.communication.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.nimlos.communication.websocket.response.Circle;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
@Setter
@Slf4j
public class ResponseHandler {

	private WebSocketSession session;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private double circleRadius = 30.0;
	private boolean increase = true;
	private double maxCircleRadius = 60.0;
	private double minCircleRadius = 15.0;
	private double circleRadiusIncrease = 0.5;

	public void sendResponse() {
		try {
			Circle circle = new Circle();
			circle.setRadius(getCircleRadius());

			// Serialize Circle object back to JSON
			String responseJson = objectMapper.writeValueAsString(circle);

			// Send response back to the client
			session.sendMessage(new TextMessage(responseJson));
		} catch (Exception e) {
			log.error("Could not send response", e);
		}
		// Prepare a Circle response (e.g., fixed radius 5)

	}

	private double getCircleRadius() {
		if (increase) {
			circleRadius += circleRadiusIncrease;
			if (circleRadius >= maxCircleRadius) {
				increase = false;
			}
		} else {
			circleRadius -= circleRadiusIncrease;
			if (circleRadius <= minCircleRadius) {
				increase = true;
			}
		}
		return circleRadius;
	}



}
