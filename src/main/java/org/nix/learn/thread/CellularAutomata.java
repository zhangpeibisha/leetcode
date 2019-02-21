package org.nix.learn.thread;

import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @author zhangpei
 * @version 1.0
 * @description 细胞自动化，使用栅栏
 * @date 2019/2/10
 */
public class CellularAutomata {

    private Logger logger = Logger.getLogger("CellularAutomata");

    private final CyclicBarrier cyclicBarrier;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    private CellularAutomata() {
        cyclicBarrier = new CyclicBarrier(1);
    }

    public void test() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.reset();
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    int await = cyclicBarrier.await();
                    logger.info("屏障打开" + await);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(1000);
        cyclicBarrier.reset();
        executorService.shutdown();
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CellularAutomata cellularAutomata = new CellularAutomata();
        cellularAutomata.test();
    }
}