package com.crm.web.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.crm.web.controller.*.*(..))")
	public void loggingForController() {}
	
	@Pointcut("execution(* com.crm.web.dao.*.*(..))")
	public void loggingForDao() {}
	
	@Pointcut("execution(* com.crm.web.service.*.*(..))")
	public void loggingForService() {}
	
	@Pointcut("loggingForController() || loggingForDao() || loggingForService()")
	public void loggingForComponents() {}
	
	@Before(" loggingForComponents()")
	public void before(JoinPoint joinPoint) {
		//display method we are calling
		String method = joinPoint.getSignature().toString();
		logger.info("=====> in @Before: Calling method: "+method);
		
		//display the method arguments
		
		Object args[] = joinPoint.getArgs();
		
		logger.info("=====> in @Before: Method Arguments:");
		for(Object arg: args) {
			logger.info(""+arg);
		}		
	}
	
	@AfterReturning(
			pointcut="loggingForComponents()",
			returning="result"
			)
	public void after(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toString();
		logger.info("=====> in @After: Calling method: "+method);
		
		logger.info("=====> in @After: Result: "+result);
	}
	
}
