package org.lhyf.mp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.spring.entity.User;
import org.lhyf.mp.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/****
 * @author YF
 * @date 2020-03-05 09:25
 * @desc MybatisPlusSpringTest
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MybatisPlusSpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

}
