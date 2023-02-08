package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect

public class Aspect4 {

    @Around("start.aop.order.aop.Pointcuts.allOrder()") // Around 애너테이션을 통해 범위를 지정해줄수도있고 pointcuts 클래스 처럼 거기서 정한 뒤 불러올 수도 있다
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @Around("start.aop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            log.info("트랜잭션 시작 -> {}" , joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("트랜잭션 롤백 -> {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("리소스 릴리즈 -> {}" , joinPoint.getSignature());
        }

    }
}
