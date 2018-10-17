package org.nix.learn.sort;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/16
 */
public interface MaxPQ <Key>{

    void  insert(Key key);

    Key max();

    Key deleteMax();

    boolean isEmpty();

    int size();

}
