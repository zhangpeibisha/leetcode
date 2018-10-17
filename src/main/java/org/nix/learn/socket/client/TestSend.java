package org.nix.learn.socket.client;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/11
 */
public class TestSend {
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            Thread thread = new Thread(new Send());
            thread.start();
        }
    }
}
