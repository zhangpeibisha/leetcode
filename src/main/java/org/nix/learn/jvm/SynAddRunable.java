package org.nix.learn.jvm;

/**
 * @author zhangpei
 * @version 1.0
 * @description 加法死锁案例
 * @date 2019/2/11
 */
public class SynAddRunable implements Runnable {

    int a, b;

    public SynAddRunable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        int nThreads = 100;
        for (int i = 0; i < nThreads; i++) {
            new Thread(new SynAddRunable(1, 2), String.valueOf(i)).start();
            new Thread(new SynAddRunable(2, 1), String.valueOf(i)).start();
        }
    }
}
