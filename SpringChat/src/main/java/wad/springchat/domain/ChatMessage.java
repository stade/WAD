package wad.springchat.domain;


/**
 *
 * @author stade
 */
public class ChatMessage {
    
    private String content;
    private int id;
    private static int counter = 1;
    

    public ChatMessage() {
        this.id = counter;
        counter++;
        content = "";
        
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ChatMessage.counter = counter;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
         this.content = content;
    }

}
