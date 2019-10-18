package com.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy2 implements InvocationHandler{
    private Productor productor;

    public Object mybind(Productor productor){
        this.productor=productor;
        return Proxy.newProxyInstance(productor.getClass().getClassLoader(),productor.getClass().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理前");
        Object rtValue = null;
        rtValue = method.invoke(productor,args);
        System.out.println("代理后");

        return rtValue;
    }
}
