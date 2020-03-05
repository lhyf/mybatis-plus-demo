package org.lhyf.mp.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.boot.entity.User;
import org.lhyf.mp.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.sql.Wrapper;

/****
 * @author YF
 * @date 2020-03-05 10:56
 * @desc MybatisPlusMethodTest
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusMethodTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert() {
        User user = new User("sunquan", "123456", "孙权",
                26, "sunquan@163.com");
        int i = userMapper.insert(user);
        System.out.println("数据库受影响的行数:" + i);
        System.out.println("自增长的ID:" + user.getId());
    }

    /**
     * 在实体类User 的 password 字段上使用
     * @TableField(select = false) 修饰, 查询时不返回该字段的值
     */
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
        // User(id=1, userName=zhangsan, password=null, name=张三, age=18, mail=zhangsan@qq.com, address=null)
    }

    /**
     * 根据ID做更新
     * 仅修改设置了值的字段
     * UPDATE t_user SET password=?, age=? WHERE id=?
     */
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1);
        user.setAge(20);
        user.setPassword("654321");
        int i = userMapper.updateById(user);
        System.out.println("数据库受影响的行数:" + i);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(21);
        user.setPassword("654321");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        int i = userMapper.update(user, wrapper);
    }

}
