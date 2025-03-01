package dk.nimlos.communication.websocket.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import dk.nimlos.common.messages.IMessageData;
import java.util.Set;
import org.reflections.Reflections;

public class JacksonConfig {

	public static ObjectMapper configureMapper() {
		ObjectMapper mapper = new ObjectMapper();
		// Scan the package "com.example.messages" for implementations of IMessageDataInterface.
		Reflections reflections = new Reflections("dk.nimlos.common.messages.messages");
		Set<Class<? extends IMessageData>> subTypes =
				reflections.getSubTypesOf(IMessageData.class);
		for (Class<? extends IMessageData> subtype : subTypes) {
			// Register each subtype with a name. You could use a custom naming strategy if needed.
			mapper.registerSubtypes(new NamedType(subtype, subtype.getSimpleName()));
		}
		return mapper;
	}
}