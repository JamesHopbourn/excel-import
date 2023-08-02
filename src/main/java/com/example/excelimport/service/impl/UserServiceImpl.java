package com.example.excelimport.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.excelimport.entity.User;
import com.example.excelimport.mapper.UserMapper;
import com.example.excelimport.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
