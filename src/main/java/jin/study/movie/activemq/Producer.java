package jin.study.movie.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:16
 * \* Description:
 * \
 */
@Component
public class Producer implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Resource
	private Queue okQueue;

	@Resource
	private Queue helloQueue;


	@Override
	public void run(String... strings) throws Exception {
		send(okQueue,"ok");
		send(helloQueue,"hello");
		logger.info("msg was send ");
	}

	public void send(Queue queue,String message){
		jmsMessagingTemplate.convertAndSend(queue,message);
	}
}
