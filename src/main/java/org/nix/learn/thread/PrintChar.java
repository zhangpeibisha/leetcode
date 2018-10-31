package org.nix.learn.thread;

import com.sun.jndi.ldap.pool.PoolCleaner;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/31
 */
public class PrintChar implements Runnable{

    private char print;

    private int number;

    private Thread thread;

    public PrintChar(char print, int number, Thread thread) {
        this.print = print;
        this.number = number;
        this.thread = thread;
    }

    @Override
    public void run() {
        if (thread!=null){
            thread.start();
        }
        for (int i = 0; i < number; i++) {
            if (i == 50){
                System.out.println();
                System.out.println(i);
                try {
                    if (thread!=null){
                        thread.join();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print(print + " ");
        }
        System.out.println();
    }
}
