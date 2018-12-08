package com.alipay.demo.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class Test004 {

    @Test
    public void test() throws InterruptedException {

        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>(80);

        Producer pro1 = new Producer(strings);

        Consumer con1 = new Consumer(strings);
        pro1.start();
        con1.start();
        //执行10秒
        Thread.sleep(1000 * 10);
        pro1.stopThread();
    }
}