package jin.study.movie.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:55
 * \* Description:
 * \
 */
@Aspect
@Component
public class ServiceMonitor {

	private final Logger logger = LoggerFactory.getLogger(ServiceMonitor.class);

	@AfterReturning("execution(* jin..aop.*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		logger.info("Completed: {}" , joinPoint);
	}

}
