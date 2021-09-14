package com.cawl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // A商品卖家
        ASellService A = new AMerchantServiceImpl();
        // B商品卖家
        BSellService B = new BMerchantServiceImpl();

        // 购买者
        String customerName = "张三";
        // 代购公司
        DCompany dCompany = new DCompany();
        dCompany.setObjFactory(A);
        //代理实例
        ASellService AProxyInstance = (ASellService) dCompany.getProxyInstance();

        System.out.println("业务员" + AProxyInstance.getClass() + "接待" + customerName);
        AProxyInstance.sale(customerName);

        System.out.println("--------------------------------------------------------------");

        //代理实例
        dCompany.setObjFactory(B);
        BSellService BProxyInstance = (BSellService) dCompany.getProxyInstance();
        System.out.println("业务员" + BProxyInstance.getClass() + "接待" + customerName);
        BProxyInstance.sale(customerName);
    }
}

interface ASellService {

    void sale(String name);
}

class AMerchantServiceImpl implements ASellService {

    @Override
    public void sale(String name) {
        System.out.println(name + "购买了A商品");
    }
}

interface BSellService {

    void sale(String name);
}

class BMerchantServiceImpl implements BSellService {

    @Override
    public void sale(String name) {
        System.out.println(name + "购买了B商品");
    }
}

class DCompany implements InvocationHandler {

    // 代理对象需要包含真实对象，为提升真实对象的复用性，则使用Object接受
    private Object objFactory;

    public void setObjFactory(Object objFactory) {
        this.objFactory = objFactory;
    }

    // 使用JDK代理类获取代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(objFactory.getClass().getClassLoader(), objFactory.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 进行业务增强
        System.out.println("JDK动态代理对业务进行了增强处理");
        // 通过反射调用方法本身
        Object invoke = method.invoke(objFactory, args);
        System.out.println("JDK动态代理对业务进行了增强处理结束");
        return invoke;
    }
}
