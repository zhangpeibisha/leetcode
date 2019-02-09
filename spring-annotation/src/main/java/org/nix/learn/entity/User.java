package org.nix.learn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description User实体
 * @date 2019/2/9
 */
@Data
public class User {

    private Integer age;

    @JsonBackReference
    private String name;

}
