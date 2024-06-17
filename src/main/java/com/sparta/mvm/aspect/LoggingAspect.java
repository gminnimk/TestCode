package com.sparta.mvm.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    // Controller 메서드 호출 이전에 실행되는 어드바이스
    @Before("execution(* com.sparta.mvm.controller.*.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {

        // 현재 ServletRequestAttributes 가져오기
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // ServletRequestAtributes가 null이 아닌 경우에만 로깅을 수행함.
        if (attributes != null) {

            // 요청한 url 과 http 메서드를 가져와서 로그로 출력.
            String url = attributes.getRequest().getRequestURL().toString();
            String httpMethod = attributes.getRequest().getMethod();
            log.info("Request: {} {}", httpMethod, url);
        }
    }
}