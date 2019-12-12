package cjlib;

import com.diao.IProducer;

/**
 * 生产者实现类，实现了生产者接口
 */
public class Producer {
    public void saleProduct(float money){
        System.out.println("卖出产品，销售额："+money);
    }

    public void afterService(float money){
        System.out.println("提供售后，花费："+money);
    }
}
