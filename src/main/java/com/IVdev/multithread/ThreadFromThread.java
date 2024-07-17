package com.IVdev.multithread;

/*
    Первый и самый простой способ создать доп.потоки в java:
    расшириться от класса Thread, переопределив метод run()
*/
public class ThreadFromThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("from thread 1: " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for(int i=1000; i > 1; i--) {
            System.out.println("from thread 2: " + i);
        }
    }
}
