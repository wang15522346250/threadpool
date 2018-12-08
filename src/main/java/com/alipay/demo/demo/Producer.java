package com.alipay.demo.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Producer extends Thread {
    private BlockingQueue queue;
    private volatile boolean flag = true;


    //采用原子类
    private AtomicInteger count = new AtomicInteger();



    public Producer(BlockingQueue queue) {
        this.queue = queue;
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    @Override
    public void run() {
        System.out.println("生产者开始启动...");
        try {
            synchronized (this) {
                while (flag) {
                    String data = count.incrementAndGet() + "";
                    //添加队列
                    boolean offer = queue.offer(data);
                    if (offer) {
                        System.out.println("生产者生产..." + data + "成功");
                    } else {
                        System.out.println("生产者生产.." + data + "失败");
                    }
                    Thread.sleep(1000);
                }
            }
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                System.out.println("生产者线程停止...");
            }
        }

        public void stopThread () {
            this.flag = false;
        }
    }

    class Consumer extends Thread {
        private BlockingQueue queue;
        private volatile boolean flag = true;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("消费者线程启动...");
            try {
                while (flag) {
                    //获取完毕，队列会删除
                    String poll = (String) queue.poll(2, TimeUnit.SECONDS);
                    if (poll != null) {
                        System.out.println("消费者消费..." + poll + "成功。。。");
                    } else {
                        System.out.println("消费者消费" + poll + "失败。。。");
                        this.flag = false;
                    }
                }

            } catch (Exception e) {

            } finally {
                System.out.println("消费者线程终止。。。");
            }
        }
    }
