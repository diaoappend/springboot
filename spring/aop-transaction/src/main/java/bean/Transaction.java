package bean;

import com.diao.utils.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("transaction")
public class Transaction {
    @Autowired
    @Qualifier("transactionUtils")
    private TransactionUtils transactionUtils;

    @Pointcut("execution(* com.diao.service.impl.*.*(..))")
    private void pt1(){}
    @Around("pt1()")
    public Object aroundTransaction(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//获取业务层切入点方法的参数
            transactionUtils.beginTransaction();
            rtValue = pjp.proceed(args);//明确调用业务层切入点方法
            transactionUtils.commitTransaction();
            return rtValue;
        } catch (Throwable t) {
            transactionUtils.rollbackTransaction();
            throw new RuntimeException(t);

        } finally {
            transactionUtils.endTransaction();
        }
    }
}
