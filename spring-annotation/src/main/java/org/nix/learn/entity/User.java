package org.nix.learn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description User实体
 * @date 2019/2/9
 */
@Data
public class User {

    public interface SimpleUser{}

    public interface DetailUser extends SimpleUser{}

    @JsonView(value = SimpleUser.class)
    private Integer age;

    @JsonView(value = SimpleUser.class)
    @JsonBackReference
    private String name;

    @JsonView(value = DetailUser.class)
    private String password;


    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //创建对象
        User user = new User();
        user.setAge(10);
        user.setName("zhangpei");
        user.setPassword("dfafafafas");
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        objectMapper.writerWithView(User.DetailUser.class).writeValue(bos, user);
        System.out.println(bos.toString());

        bos.reset();
        objectMapper.writerWithView(User.SimpleUser.class).writeValue(bos, user);
        System.out.println(bos.toString());
    }
}
