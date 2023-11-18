package by.pvt.fooddelivery.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut(value = "@annotation(by.pvt.fooddelivery.logging.Logging)")
    public void loggingController() {
    }

    @Around(value = "loggingController()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o;
        try {
            log.info("Started the \"" + joinPoint.getSignature().getName() + "\" method from the \"" + joinPoint.getSignature().getDeclaringTypeName() + "\" controller. Time: {}", LocalDateTime.now());
            o = joinPoint.proceed();
            log.info("Finished the \"" + joinPoint.getSignature().getName() + "\" method from the \"" + joinPoint.getSignature().getDeclaringTypeName() + "\" controller. Time: {}", LocalDateTime.now());

        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return o;
    }
}
