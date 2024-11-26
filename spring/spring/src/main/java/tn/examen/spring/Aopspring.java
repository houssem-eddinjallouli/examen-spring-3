package tn.examen.spring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Aopspring {


    @AfterThrowing("execution(* tn.examen.spring.services.IExamenService.ajouterTicketsEtAffecterAEvenementEtInternaute(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("le nombre de places restant depasse le nombre de tickets demandées " );
    }










    //
//
//    @Before("execution(* tn.esprit.ski.service.EquipeServiceImpl.*(..))")
//    @After("….....")
//    public void logMethodEntry(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("In method " + name + " : ");
//    }
//
//
//
//    @Before("execution(* tn.esprit.ski.service.*.*(..))")
//• @Before("execution(public * *(..))")
//• @Before("execution(* set*(..))")
//• @Before("execution(* tn.esprit.ski..*.*(..))")
//
//
//
//
//    @Around("execution(* tn.esprit.ski.service.*.*(..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return obj;
//    }
//
}
