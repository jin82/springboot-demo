package jin.study.movie.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 15:37
 * \* Description:
 * \
 */
public class StartUpRunner implements CommandLineRunner{

	protected final Logger logger = LoggerFactory.getLogger(StartUpRunner.class);

	@Override
	public void run(String... strings) throws Exception {
		logger.info("Hello World!");
	}
}
