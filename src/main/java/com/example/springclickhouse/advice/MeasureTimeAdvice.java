package com.example.springclickhouse.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class MeasureTimeAdvice {

    @Around("@annotation(MeasureTime)")
    public Object measureTime(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch("MeasureTime");
        stopWatch.start();
        Object object = point.proceed();
        stopWatch.stop();
        log.info("{} - {} ms", point.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return object;
    }

}
