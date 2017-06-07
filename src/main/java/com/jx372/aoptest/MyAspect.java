package com.jx372.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	
	@Before("execution(public ProductVo com.jx372.aoptest.ProductService.find(..))") //메소드 지정을  해줘야함 pointcut
	public void beforeAdvice(){
		
		System.out.println("beforeAdvice() called");
		
	}
	@After("execution(ProductVo com.jx372.aoptest.ProductService.find(..))") //public 접근지시자  생략할수 있음 
	public void afterAdvice(){
		
		
		System.out.println("afterAdvice() called");
		
	}
	
	@AfterReturning("execution(* com.jx372.*.ProductService.find(..))") //모든 리턴타입, 모든 패키지 
	public void afterReturningAdvice(){
		
		
		
		System.out.println("afterReturning() called");
	}
	
	
	@AfterThrowing(value="execution(* *..*.ProductService.*(..))",throwing="ex")
	public void afterThrowingAdvice(Throwable ex){
		System.out.println("afterThrowing() called"+ex);
	}
	
	@Around("execution(* *..*.*.*(..))")
	public Object aroundAdcice(ProceedingJoinPoint pjp) throws Throwable{ //많이 사용함 
		// before advice
		System.out.println("[before]aroundAdvice() called");
		
			Object[] parameters = {"camera"};
			Object result = pjp.proceed(parameters); //메소드 핵심코드 실행 , 새로 구현하는 거라서 return 값이 필요함 !!!
		
		// after advice
		System.out.println("[after]aroundAdvice() called");
		
		return result;
	}
	

}
