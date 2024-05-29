package com.IVdev.multithread;

public class ThreadFromRunnable {
    public static void main(String[] args) {
        Thread thread3 = new Thread(new Thread3());
        Thread thread4 = new Thread(new Thread4());
        thread3.start();
        thread4.start();
    }
}

class Thread3 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i < 1000; i++) {
            System.out.println("..from THREAD3: "+i);
        }
    }
}

class Thread4 implements Runnable {
    @Override
    public void run() {
        for(int i=1000; i > 1; i--) {
            System.out.println("..from THREAD4: "+i);
        }
    }
}
