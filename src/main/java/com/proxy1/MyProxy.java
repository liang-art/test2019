package com.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    public static void main(String[] args) {
        final Productor productor = new Productor();

        IProductor iProductor = (IProductor) Proxy.newProxyInstance(productor.getClass().getClassLoader(), productor.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        System.out.println("代理处理前");
                        float money = (Float)args[0];
                        rtValue = method.invoke(productor,money*0.2f);
                        System.out.println("代理处理后");
                        return rtValue;
                    }

                });


        iProductor.product(1000f);
    }
}
