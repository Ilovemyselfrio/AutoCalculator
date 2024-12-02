package com.itherma.springbootquickstart;

import com.itherma.springbootquickstart.dao.Student;
import com.itherma.springbootquickstart.entity.User;
import com.itherma.springbootquickstart.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class SpringbootQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testInsert() {
        long now = Instant.now().toEpochMilli();
    User user = User.builder()
            .name("ruiruiho")
            .age(20)
            .email("abc@qq.com")
            .createTime(now)
            .updateTime(now)
            .build();
    userMapper.insert(user);
    }

}
