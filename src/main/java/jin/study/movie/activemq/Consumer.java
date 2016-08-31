package jin.study.movie.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:27
 * \* Description:
 * \
 */
@Component
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = ActiveMqConfiguration.HELLO_QUEUE)
	public void receiveHello(String message){
		logger.info("消息队列为 {} ,消息是 {}",ActiveMqConfiguration.HELLO_QUEUE,message);
	}

	@JmsListener(destination = ActiveMqConfiguration.OK_QUEUE)
	public void receiveOk(String message){
		logger.info("消息队列为 {} ,消息是 {}",ActiveMqConfiguration.OK_QUEUE,message);
	}

}
