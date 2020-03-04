package org.lhyf.mp.simple.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.lhyf.mp.simple.entity.User;
import org.lhyf.mp.simple.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/****
 * @author YF
 * @date 2020-03-04 21:53
 * @desc MybatisTest
 *
 **/
public class MybatisTest {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }



    @Test
    public void testFindAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);

        session.close();
    }
}
