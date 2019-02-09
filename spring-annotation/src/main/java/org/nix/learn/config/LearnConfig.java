package org.nix.learn.config;


import org.nix.learn.entity.User;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学习注解配置类
 * @date 2019/2/9
 */
@Configuration(value = "你到底是是不是名字")
public class LearnConfig implements Condition {

    @Bean
    @ConditionalOnMissingBean(value = {User.class})
    public User currUser() {
        return new User();
    }

    @Bean
    public User systemUser(){
        return new User();
    }

    /**
     * @param context spring 上下文
     * @param metadata 注解所在位置的注释信息
     * @return boolean
     * @description @Conditional 的基础实现，如果返回true则注入否者不注入bean
     * @author zhangpe0312@qq.com
     * @date 2019/2/9
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
