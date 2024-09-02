package dsw.primeiro_projeto.aspecto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class InterceptadorAspectos {
	@Pointcut("execution(* dsw.primeiroprojeto.user.*.*(..))")
	public void loggingPointCut() {	}
	
	@Before("loggingPointCut()")
	public void before(JoinPoint joinPoint) {
//		log.info("Before method invoked::" + joinPoint.getSignature());
		System.out.println("Before method invoked::" + joinPoint.getSignature());
	}
	
	@After("loggingPointCut()")
	public void after(JoinPoint joinPoint) {
//		log.info("After method invoked::" + joinPoint.getSignature());
		System.out.println("After method invoked::" + joinPoint.getSignature());
	}
}
