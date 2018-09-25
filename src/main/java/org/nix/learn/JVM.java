package org.nix.learn;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 此代码演示了两点：
 * 1.对象可以再被GC时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/21
 */
public class JVM extends PhantomReference<String> {
    public String name;
    public static JVM SAVE_HOOK = null;

    public JVM(String name) {
        super(name,new ReferenceQueue<String>());

        this.name = name;
    }

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        System.out.println(this);
        JVM.SAVE_HOOK = this;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new JVM("leesf");
        System.out.println(SAVE_HOOK);
        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.out.println(SAVE_HOOK);
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }

        // 下面这段代码与上面的完全相同,但是这一次自救却失败了
        // 一个对象的finalize方法只会被调用一次
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }

        ThreadLocal local = new ThreadLocal();
        local.set("zhangpie");
    }
}
