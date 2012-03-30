package wad.validoituchat.service;

import java.util.Queue;
import wad.validoituchat.domain.ChatMessage;



public interface MessageService {
    public void add(ChatMessage message);
    public Queue<ChatMessage> list();
    public void delete(int messageId);
}