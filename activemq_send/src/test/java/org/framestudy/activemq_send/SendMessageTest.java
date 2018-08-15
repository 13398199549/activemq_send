package org.framestudy.activemq_send;

import javax.annotation.Resource;

import org.apache.activemq.command.ActiveMQDestination;
import org.framestudy.activemq.send.SendMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-activemq.xml")
public class SendMessageTest {

	@Resource
	private SendMessage sendMessage;
	
	@Resource(name="topicDestination")
	private ActiveMQDestination topicDestination;
	
	@Resource(name="queueDestination")
	private ActiveMQDestination queueDestination;
	
	@Test
	public void send() {
		
		try {
			
			for (int i = 0; i < 30; i++) {
				//数据向queue://message中传输
				sendMessage.sendMessage(topicDestination,"向主题发布的测试数据：" + i);
				
				sendMessage.sendMessage(queueDestination,"向队列发布的测试数据：" + i);

				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
