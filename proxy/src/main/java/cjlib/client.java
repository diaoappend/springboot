package cjlib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class client {


    public static void main(String[] args) {
        final Producer producer = new Producer();
        Producer cjProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return 和被代理对象有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (float)args[0];
                if("saleProduct".equals(method.getName())){

                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cjProducer.saleProduct(12000f);
    }
}
