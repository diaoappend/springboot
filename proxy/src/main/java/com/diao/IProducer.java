package com.diao;

/**
 * 生产者接口，有销售和售后两个方法
 */
public interface IProducer {
    public void saleProduct(float money);

    public void afterService(float money);
}
