package wad.springchat.service;

import java.util.Queue;
import wad.springchat.domain.ChatMessage;



public interface MessageService {
    public void add(ChatMessage message);
    public Queue<ChatMessage> list();
    public void delete(int messageId);
}