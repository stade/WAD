/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author stade
 */
public class Viestijono {

    private Queue<String> viestit;

    public Viestijono() {
        viestit = new LinkedList();
    }

    public Queue<String> getViestit() {
        return viestit;
    }

    public void setViestit(Queue<String> viestit) {
        this.viestit = viestit;
    }

    public void lisaaViestijonoon(String viesti) {
        if (this.viestit.size() < 10) {

            this.viestit.offer(viesti);

        } else {
            viestit.remove();
            viestit.offer(viesti);
        }
    }
}
