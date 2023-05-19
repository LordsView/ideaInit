package com.demo.fanxing;

public class FanXingTest {
    public static void main(String[] args) {
        Show<String> show = new Show<>();
//        show.print1(new Integer(1));
        show.print2(new Integer(1));
    }
}

class Show<T>{
    void print1(T t){
        System.out.println(t);
    }

    <T> void print2(T t){
        System.out.println(t);
    }
}