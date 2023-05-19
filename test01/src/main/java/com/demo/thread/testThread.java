package com.demo.thread;


import java.util.concurrent.*;

/**
 * 类 名: testThread
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2020/4/17
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class testThread {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        MyTask task = new MyTask();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("my task执行结果"+result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }


}

class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算...");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
