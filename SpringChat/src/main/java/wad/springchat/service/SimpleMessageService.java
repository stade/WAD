package wad.springchat.service;


import java.util.LinkedList;
import java.util.Queue;
import org.springframework.stereotype.Service;
import wad.springchat.domain.ChatMessage;


@Service
public class SimpleMessageService implements MessageService {

    private Queue<ChatMessage> messages = new LinkedList();

    @Override
    public void add(ChatMessage message) {
        if (this.messages.size() < 10) {

            this.messages.offer(message);

        } else {
            messages.remove();
            messages.offer(message);
        }
    }
    @Override
    public Queue<ChatMessage> list() {
        return messages;
    }

    @Override
    public void delete(int messageId) {
        
        ChatMessage delThisMsg = null;
        
        for (ChatMessage msg : messages ){
            if (msg.getId() == messageId) {
                delThisMsg = msg;
                break;
            }
        }
        
        if (delThisMsg != null) {
            messages.remove(delThisMsg);
        }
    }
}
