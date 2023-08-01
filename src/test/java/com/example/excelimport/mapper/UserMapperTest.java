package com.example.excelimport.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.excelimport.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void selectByField(){

        List<String> uniqueField = Arrays.asList("name", "gender");
        
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select(uniqueField);
        List<User> users = userMapper.selectList(userQueryWrapper);
        

    }

}