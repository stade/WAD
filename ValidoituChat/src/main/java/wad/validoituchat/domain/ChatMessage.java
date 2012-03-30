package wad.validoituchat.domain;


import javax.validation.constraints.*;


/**
 *
 * @author stade
 */
public class ChatMessage {
    
    @NotNull(message="Viestin sisältö ei saa olla tyhjä")
    @Size(min=1, max=300, message="Viestissä saa olla maksimissaan 300 merkkiä!")       
    @Pattern(regexp="[a-zA-Z0-9]+",
          message="Viestin tulee muodostua vain kirjaimista ja numeroista")
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
