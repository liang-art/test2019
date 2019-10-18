package com.proxy2;

public class Test1 {
    public static void main(String[] args) {
        IProductor iProductor =(IProductor) new MyProxy2().mybind(new Productor());

        iProductor.product("代理处理");
    }
}
