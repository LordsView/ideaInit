package com.demo.thread;

/**
 * @program: workspace-IDEAInit
 * @description: 新建四个线程，两个加一，两个减一
 * @author: lzz
 * @create: 2022-03-14 11:10
 */
public class FourThread {
    //j变量私有
    private int j;
    //同步的+1方法
    private synchronized void add(){
        j++;
        System.out.println(Thread.currentThread().getName()+"----------> "+j);
    }
    //同步的-1方法
    private synchronized void subtract(){
        j--;
        System.out.println(Thread.currentThread().getName()+"----------> "+j);
    }
    //实现Runnable接口的内部加类
    class Add implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                add();
            }
        }
    }
    //实现Runnable接口的内部减类
    class Subtract implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                subtract();
            }
        }
    }

    public static void main(String[] args) {
        //创建外部类和内部类的实例
        FourThread mt = new FourThread();
        Add add = mt.new Add();
        Subtract subtract = mt.new Subtract();
        //循环启动4个线程
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(add);
            t.start();
            t = new Thread(subtract);
            t.start();
        }
    }
}