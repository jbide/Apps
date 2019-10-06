package fr.jyb.app.rest.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Aspect
@Slf4j
public class RequestLogAspect {

    @Around("fr.jyb.app.rest.aop.AspectPointCut.serviceRestExecution()")
    public Object adviceWhenServiceRestIsCalled(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable  {
        Object value;

        try {
            log.info("Call to service Rest " + proceedingJoinPoint.getSignature());
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        return value;
    }
}
