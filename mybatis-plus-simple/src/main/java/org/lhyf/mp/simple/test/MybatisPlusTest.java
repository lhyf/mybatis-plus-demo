package org.lhyf.mp.simple.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.lhyf.mp.simple.entity.User;
import org.lhyf.mp.simple.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/****
 * @author YF
 * @date 2020-03-04 22:07
 * @desc MybatisPlusTest
 *
 **/
public class MybatisPlusTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 使用MybatisSqlSessionFactoryBuilder 构建
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }


    @Test
    public void findAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);

        session.close();
    }


    @Test
    public void TestselectList() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        session.close();

    }
}
