package dk.nimlos.common.messages.messages;

import dk.nimlos.common.messages.IMessageData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageA implements IMessageData {

	public String text;

}
