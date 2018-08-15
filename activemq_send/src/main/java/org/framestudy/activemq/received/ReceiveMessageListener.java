package org.framestudy.activemq.received;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class ReceiveMessageListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		TextMessage tm = (TextMessage) msg;
        try {
            System.out.println("ReceiveMessageListener监听到了文本消息：\t"
                    + tm.getText());
            //do something ...
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
	}
}
