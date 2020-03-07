package org.lhyf.mp.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.boot.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/****
 * @author YF
 * @date 2020-03-07 20:08
 * @desc ActiveRecordTest
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveRecordTest {

    /**
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE id=1;
     */
    @Test
    public void testSelectByUserId() {
        User user = new User();
        user.setId(1);

        User user1 = user.selectById();

        System.out.println(user1);
    }

    /**
     * INSERT INTO t_user ( user_name, password, name, age, email ) VALUES ( 'xiaohong', '123123', '小红', 20, 'xiaohong@outlook.com' );
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("xiaohong");
        user.setPassword("123123");
        user.setAge(20);
        user.setMail("xiaohong@outlook.com");
        user.setName("小红");

        boolean insert = user.insert();
        System.out.println("插入成功? " + insert);
    }

    /**
     * UPDATE t_user SET user_name='xiaozao', password='123123', name='小皂', age=20, email='xiaozao@outlook.com'
     * WHERE id=7;
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(7);
        user.setUserName("xiaozao");
        user.setPassword("123123");
        user.setAge(20);
        user.setMail("xiaozao@outlook.com");
        user.setName("小皂");


        boolean result = user.updateById();
        System.out.println("更新成功? " + result);
    }

    /**
     * DELETE
     * FROM t_user
     * WHERE id=7;
     */
    @Test
    public void testDelete() {
        User user = new User();
        user.setId(7);
        boolean result = user.deleteById();
        System.out.println("删除成功? " + result);
    }

    /**
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE age = 20;
     */
    @Test
    public void testSelectList() {
        User user = new User();
        user.setId(7);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age", 20);
        List<User> users = user.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 测试 SqlExplainInterceptor 拦截器, 拦截全表更新
     */
    @Test
    public void testUpdateAll() {
        User user = new User();
        user.setAge(18);
        boolean update = user.update(null);
        System.out.println("更新成功? " + update);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testUpdateVersion() {
        User user = new User();
        user.setId(1);
        user.setAge(20);

        // 设置当前的版本信息
        user.setVersion(1);

        boolean update = user.updateById();
        System.out.println("更新成功? " + update);

    }
}
