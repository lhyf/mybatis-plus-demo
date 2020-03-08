package org.lhyf.mp.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.boot.entity.User;
import org.lhyf.mp.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/****
 * @author YF
 * @date 2020-03-08 12:34
 * @desc CommonMapperTest
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试自定义SQL语句生成器
     */
    @Test
    public void testCommonMapper() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);

    }
}
