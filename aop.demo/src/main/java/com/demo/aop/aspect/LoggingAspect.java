package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(public String com.demo.aop.controller.StudentController.getStudent())")
	public void beforeMethod() {
		System.out.println("Inside before method of Aspect");
	}

}
