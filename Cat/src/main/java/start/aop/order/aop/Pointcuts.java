package start.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* start.aop.order..*(..))") //start.aop.order 밑 하위 폴더는 모두 적용?
    public void allOrder(){}

    @Pointcut("execution(* *..*Service.*(..))") // Service가 들어간 모든 폴더에 적용? (*Service로 쓰네 만약 Order*로쓰면 이것만되는건가)
    public void allService(){}

    @Pointcut("allOrder() && allService()") //이건 모든 order , service 다 적용하라는거자나
    public void orderAndService(){}
}
