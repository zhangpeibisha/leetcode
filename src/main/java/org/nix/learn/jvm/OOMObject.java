package org.nix.learn.jvm;

/**
 * @author zhangpei
 * @version 1.0
 * @description 一个大对象，占用内存64kb
 * @date 2019/2/11
 */
public class OOMObject {

    private byte[] placeholder = new byte[64*1024];

}
