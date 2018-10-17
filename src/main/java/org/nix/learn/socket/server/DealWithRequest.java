package org.nix.learn.socket.server;

import java.io.*;
import java.net.Socket;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/11
 */
public class DealWithRequest implements Runnable{

    private Socket socket;

    private Integer index;

    public DealWithRequest(Socket socket) {
        this.socket = socket;
    }

    public DealWithRequest(Socket socket, Integer index) {
        this.socket = socket;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            socket.getOutputStream().write(("你好客户端，你的地址是" + socket.getInetAddress()).getBytes());
        } catch (IOException e) {
            System.out.println("接收信息失败");
        }
    }


}
