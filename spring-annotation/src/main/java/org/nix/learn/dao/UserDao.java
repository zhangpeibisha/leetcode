package org.nix.learn.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description 持久层组件
 * @date 2019/2/9
 */
@Component(value = "userDao")
@Slf4j
public class UserDao implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        // 执行任务
        log.info("执行任务UserDao:{} ===> 自定义beanName: {}",getClass().getName(),
                getClass().getAnnotation(Component.class).value());
    }
}
