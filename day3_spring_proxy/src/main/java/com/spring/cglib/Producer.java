package com.spring.cglib;


import com.spring.proxy.IProducer;

/**
 * 生产者
 */
public class Producer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，得到钱：" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterProduct(float money){
        System.out.println("售后产品，获得钱：" + money);
    }
}
