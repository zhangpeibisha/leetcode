package org.nix.learn.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangpei
 * @version 1.0
 * @description 细胞自动化，使用栅栏
 * @date 2019/2/10
 */
public class CellularAutomata {

    private CyclicBarrier cyclicBarrier;

    public CellularAutomata(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void test(){
        cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}