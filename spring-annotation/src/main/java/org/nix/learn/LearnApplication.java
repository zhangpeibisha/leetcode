package org.nix.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhangpei
 * @version 1.0
 * @description 注解使用学习应用
 * @date 2019/2/9
 */
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan
public class LearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LearnApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
