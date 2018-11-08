package org.nix.learn;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/24
 */
public class CJLIB extends Test implements MethodInterceptor {

    //通过Enhancer 创建代理对象
    private Enhancer enhancer = new Enhancer();

    //通过Class对象获取代理对象
    public Object getProxy(Class c){
        //设置创建子类的类
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志开始...");
        //代理类调用父类的方法
        methodProxy.invokeSuper(o, objects);
        System.out.println("日志结束...");
        return null;
    }

    public static void main(String[] args) {
        CJLIB cjlib = new CJLIB();
        Test test = (Test) cjlib.getProxy(Test.class);
        test.print();
    }
}


class Test {
    public void print(){
        System.out.println("我不是静态方法");
    }
    public static void printS(){
        System.out.println("我是静态方法");
    }
}
