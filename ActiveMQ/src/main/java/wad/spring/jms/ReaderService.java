/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsTemplate;





/**
 *
 * @author stade
 */
public class ReaderService implements JmsReader {
    
    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public String read() throws JMSException {
       String message;
       Message receive = jmsTemplate.receive("the_queue");
       
       message = String.valueOf(receive);
       
       return message;
          
    }  
}
