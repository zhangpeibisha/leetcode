package org.nix.learn.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangpei
 * @version 1.0
 * @description controller异常处理
 * @date 2019/2/10
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String exception(){
        return null;
    }

}
