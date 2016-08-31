package jin.study.movie.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:53
 * \* Description:
 * \
 */
@Component
public class HelloWorldService {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	@Value("${name}")
	private String name;

	public void sayHello() {
		logger.info("{} say Hello World",name);
	}

}
