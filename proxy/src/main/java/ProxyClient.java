import com.diao.IProducer;
import com.diao.Producer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClient {

    public static void main(String[] args) {
        final Producer producer = new Producer();

        IProducer proxyProducer =(IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强的方法，这里我们要做的就是判断执行的方法是否是销售，如果是，money*0.8
                        //获取方法执行的参数,这里只有一个参数
                        Object returnValue = null;
                        Float money = (float)args[0];
                        if("saleProduct".equals(method.getName())){

                             returnValue=method.invoke(producer,money*0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
