package com.example.excelimport.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.excelimport.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
