package jin.study.movie.activemq;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:18
 * \* Description:
 * \
 */
@Configuration
@EnableJms
public class ActiveMqConfiguration {

	public static final String OK_QUEUE = "ok-queue";
	public static final String HELLO_QUEUE = "hello-queue";

	@Bean
	public Queue helloQueue(){
		return new ActiveMQQueue(HELLO_QUEUE);
	}

	@Bean
	public Queue okQueue() {
		return new ActiveMQQueue(OK_QUEUE);
	}
}
