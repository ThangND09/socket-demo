package thang.nguyen.socket.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final Message message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
    
    @MessageMapping("/thang")
    public void send2(final Message message) throws Exception {

    	sendMess(message);
        
    }
    
    @SendTo("/topic/messages")
    private OutputMessage sendMess(final Message message) {
    	final String time = new SimpleDateFormat("HH:mm").format(new Date());
    	return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}