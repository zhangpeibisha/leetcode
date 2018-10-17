package org.nix.learn.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/11
 */
public class Server {

    private volatile static int number = 0;

    public static void main(String[] args) {
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                DealWithRequest request = new DealWithRequest(socket);
                pool.execute(request);
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败" + e.getMessage());
        }
    }

    private static Lock lock = new ReentrantLock();

    public static int dealNumber() {
        try {
            lock.lock();
            return ++number;

        } finally {
            lock.unlock();
        }
    }

}
