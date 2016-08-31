package jin.study;

import jin.study.movie.runner.StartUpRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class SpringbootApplication {

	@Bean
	public StartUpRunner startUpRunner(){
		return new StartUpRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
