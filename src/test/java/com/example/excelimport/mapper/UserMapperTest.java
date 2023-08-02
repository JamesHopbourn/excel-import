package com.example.excelimport.mapper;

import com.example.excelimport.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void selectByField(){

        List<String> uniqueField = Arrays.asList("name", "gender");

        // 数据库查出来的诗句
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.select(uniqueField);
//        List<User> users = userMapper.selectList(userQueryWrapper);
//        System.out.println(users);

        List<User> databaseUserList = new ArrayList<>();
        User databaseUserOne = User.builder().id("1").build();
        User databaseUserTwo = User.builder().id("2").build();
        databaseUserList.add(databaseUserOne);
        databaseUserList.add(databaseUserTwo);

        List<String> collect = databaseUserList.stream().map(User::getId).collect(Collectors.toList());
        System.out.println(collect);
        
        // 用户导入的数据
        List<User> importUserList = new ArrayList<>();
        User user = User.builder().id("1").build();
        User userThree = User.builder().id("3").build();
        importUserList.add(user);
        importUserList.add(userThree);

        List<User> duplicate = importUserList.stream()
                                .filter(importUser -> collect.contains(importUser.getId()))
                                .collect(Collectors.toList());
        System.out.println(duplicate);
    }

}