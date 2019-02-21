package org.nix.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author zhangpei
 * @version 1.0
 * @description 使用信号量作为容器边界
 * @date 2019/2/10
 */
public class MyList {
    /**
     * 容器
     */
    private List<Integer> list;
    /**
     * 容器边界
     */
    private Semaphore semaphore;

    public MyList(List<Integer> list, int size) {
        this.list = list;
        this.semaphore = new Semaphore(size);
    }

    public boolean add(Integer value) throws InterruptedException {
        System.out.println("申请资源" + value);
        // 申请资源
        semaphore.acquire();
        System.out.println("申请资源成功" + value);
        boolean wasAdd = false;
        try {
            wasAdd = list.add(value);
            return wasAdd;
        } finally {
            if (!wasAdd) {
                // 释放资源
                semaphore.release();
            }
        }
    }

    public boolean remove(int value) {
        System.out.println("准备释放资源" + value);
        Integer wasRemove = list.remove(value);
        if (wasRemove != null) {
            semaphore.release();
            System.out.println("释放资源成功" + value);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        MyList myList = new MyList(new ArrayList<>(), 10);
        for (int i = 0; i < 9; i++) {
            try {
                myList.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 20; i++) {
            try {
                myList.remove(i);
                myList.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
