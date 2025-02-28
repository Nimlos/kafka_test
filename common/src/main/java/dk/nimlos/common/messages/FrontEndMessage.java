package dk.nimlos.common.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontEndMessage {

	private String messageName;
	private IMessageData messageData;

}
