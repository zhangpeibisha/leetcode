package org.nix.learn.socket.client;

import java.io.*;
import java.net.Socket;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/11
 */
public class Send implements Runnable{

    private Socket client;

    @Override
    public void run() {
        try {
            client = new Socket("127.0.0.1",8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
