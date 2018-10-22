package org.nix.learn.socket.udp;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/19
 */
public class UdpClient extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{});
        Object o = new Object();
        return null;
    }
}
