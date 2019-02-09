package org.nix.learn.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学习注解配置类
 * @date 2019/2/9
 */
@Configuration(value = "你到底是是不是名字")
@EnableAutoConfiguration
@ComponentScan
public class LearnConfig {

}
