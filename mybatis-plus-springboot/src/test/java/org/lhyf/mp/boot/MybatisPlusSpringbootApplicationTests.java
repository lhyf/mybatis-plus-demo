package org.lhyf.mp.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.boot.entity.User;
import org.lhyf.mp.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusSpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
