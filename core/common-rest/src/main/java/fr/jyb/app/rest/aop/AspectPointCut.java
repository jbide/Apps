package fr.jyb.app.rest.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AspectPointCut {

    @Pointcut("execution(public * fr.jyb.app.rest.service.*.*(..))")
    public void serviceRestExecution(){}
}
