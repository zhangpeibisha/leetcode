package org.nix.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/31
 */
public class PrintCharTest {

    public static void main(String[] args) {
        Condition condition;
        PrintChar printA =
                new PrintChar('A',100,
                       new Thread( new PrintChar('B',50,null)));
        Thread threadA = new Thread(printA,"打印A");
        threadA.start();
        List<byte[]> list = new ArrayList<>();
        while (true){
            byte[] value = new byte[1024];
            list.add(value);
//            System.gc();
        }
    }

}
