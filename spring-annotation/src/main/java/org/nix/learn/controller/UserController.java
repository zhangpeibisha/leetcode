package org.nix.learn.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.nix.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户控制器
 * @date 2019/2/9
 */
@RestController
@Qualifier
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserController userController;

    @GetMapping("/hello/word/{name}")
    public String helloWord(@PathVariable(name = "name")String name){
        return "hello word" + name;
    }
}
