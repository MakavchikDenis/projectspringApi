package by.makavchik.projectspring.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspetc {
    long varTime=0;

    @Pointcut("@annotation(LogAnnotation)")
    public void callAtPersonController() {
    }

   @Around("@annotation(MyLogAnnotation)")
   public Object funMyAnnotation(ProceedingJoinPoint pjp) throws Throwable {

       Date obDate=new Date();
       varTime=(long)obDate.getTime();
       Object ob=pjp.proceed();//выполняем осноыную функцию
       varTime=(((long) new Date().getTime())-varTime);
       log.info("the execution of the method: "+varTime + " мc.");
       return ob;
   }


    @Before("callAtPersonController()")
    public void beforeCallMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtPersonController()")
    public void afterCallAt(JoinPoint jp) {
        log.info("after " + jp.toString());
    }

}


