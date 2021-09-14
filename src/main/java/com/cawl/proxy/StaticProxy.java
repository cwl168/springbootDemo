package com.cawl.proxy;

import lombok.extern.slf4j.Slf4j;

public class StaticProxy {
    public static void main(String[] args) {
        TargetFactoryServiceImpl service = new TargetFactoryServiceImpl();
        ProxyImpl proxy = new ProxyImpl(service);
        proxy.sale("代购公司");
    }
}

//抽象对象
interface ITargetFactoryService {
    void sale(String name);
}

//目标对象
@Slf4j
class TargetFactoryServiceImpl implements ITargetFactoryService {
    @Override
    public void sale(String name) {
        log.info(name + "购买了商品A");
    }
}

//代理对象
@Slf4j
class ProxyImpl implements ITargetFactoryService {
    public ITargetFactoryService service;
    public ProxyImpl(ITargetFactoryService service) {
        super();
        this.service = service;
    }

    @Override
    public void sale(String name) {
        before();
        service.sale(name);
        after();
    }

    /**
     * 后置增强
     */
    private void after() {
        log.info("代购在购买后得到了市场调研结果");
    }

    /**
     * 前置增强
     */
    private void before() {
        log.info("代购在购买前做了市场调研");
    }
}