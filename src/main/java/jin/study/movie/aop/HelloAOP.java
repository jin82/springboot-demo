package jin.study.movie.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:53
 * \* Description:
 * \
 */
@Component
public class HelloAOP implements CommandLineRunner {

	@Resource
	HelloWorldService helloWorldService;

	@Override
	public void run(String... strings) throws Exception {
		helloWorldService.sayHello();
	}
}
