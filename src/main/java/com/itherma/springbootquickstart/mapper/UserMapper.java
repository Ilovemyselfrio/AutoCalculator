package com.itherma.springbootquickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itherma.springbootquickstart.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
