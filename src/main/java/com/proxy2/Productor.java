package com.proxy2;

public class Productor implements  IProductor{

    public void product(String msg) {
        System.out.println("原厂家开始生产=====》"+msg);
    }
}
