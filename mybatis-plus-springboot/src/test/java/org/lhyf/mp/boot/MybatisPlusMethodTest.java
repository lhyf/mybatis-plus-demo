package org.lhyf.mp.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhyf.mp.boot.entity.User;
import org.lhyf.mp.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /***********************************插入操作*************************************************/
    /**
     * 实体类为 null 的字段, 不会被插入
     * INSERT INTO t_user ( user_name, password, name, email ) VALUES ( 'xiaohong', '123', '小红', 'xiaohong@163.com' );
     */
    @Test
    public void testInsert() {
        User user = new User("xiaohong", "123", "小红",
                null, "xiaohong@163.com");
        int i = userMapper.insert(user);
        System.out.println("数据库受影响的行数:" + i);
        System.out.println("自增长的ID:" + user.getId());
    }

    /***********************************查询操作*************************************************/
    /**
     * 在实体类User 的 password 字段上使用
     *
     * @TableField(select = false) 修饰, 查询时不返回该字段的值
     */
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
        // User(id=1, userName=zhangsan, password=null, name=张三, age=18, mail=zhangsan@qq.com, address=null)
    }

    /**
     * 根据ID批量查询
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE id IN ( 1 , 2 , 3 , 4 , 5 , 16 );
     */
    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 16));
        users.forEach(System.out::println);
    }

    /**
     * 根据条件查询一条数据
     */
    @Test
    public void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age", 21);

        // 查询结果超过一条时,会抛出异常
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * SELECT COUNT( 1 )
     * FROM t_user
     * WHERE age > 20;
     */
    @Test
    public void testSelectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20); // 查询条件大于 20 岁的

        Integer count = userMapper.selectCount(wrapper);
        System.out.println("一共查询到:" + count + " 条数据");
    }

    /**
     * 查询多条记录
     * <p>
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE email LIKE '%outlook%';
     */
    @Test
    public void testSelectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "outlook"); //

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 分页查询, 需要做分页配置
     * SELECT COUNT(1)
     * FROM t_user
     * WHERE email LIKE '%outlook%';
     * <p>
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE email LIKE '%outlook%'
     * LIMIT 0,2;
     */
    @Test
    public void testSelectPage() {
        IPage<User> page = new Page<>(0, 1);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "outlook"); //

        IPage<User> userIPage = userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数:" + userIPage.getTotal());
        System.out.println("数据总页数:" + userIPage.getPages());

        // 获取查询的数据记录
        List<User> users = userIPage.getRecords();
        users.forEach(System.out::println);
    }


    /***********************************更新操作*************************************************/
    /**
     * 根据ID做更新
     * 仅修改设置了值的字段
     * UPDATE t_user SET password=?, age=? WHERE id=?
     */
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1);
        user.setAge(20);
        user.setPassword("654321");
        int i = userMapper.updateById(user);
        System.out.println("数据库受影响的行数:" + i);
    }

    /**
     * 使用 QueryWrapper 更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setAge(21);
        user.setPassword("654321");

        // 根据 wrapper 封装的条件去更新,更新后的值为 user 封装的内容
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "zhangsan");
        int i = userMapper.update(user, wrapper);
    }

    /**
     * 使用 UpdateWrapper 更新
     */
    @Test
    public void testUpdate2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 21).set("password", "12345") // 更新的字段
                .eq("user_name", "zhangsan"); // 更新的条件

        int i = userMapper.update(null, wrapper);
    }

    /***********************************删除操作*************************************************/
    /**
     * 根据ID删除
     */
    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(15);

        System.out.println("受影响的行数:" + i);
    }

    /**
     * 根据Map封装的条件做删除操作, 多条件之间是 AND 连接
     * DELETE
     * FROM t_user
     * WHERE password = '1111' AND user_name = 'xiaoqing';
     */
    @Test
    public void testDeleteByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name", "xiaoqing");
        columnMap.put("password", "1111");

        int i = userMapper.deleteByMap(columnMap);

        System.out.println("受影响的行数:" + i);
    }

    /**
     * 根据 QueryWrapper 包装的条件进行删除
     * 方法一
     */
    @Test
    public void testDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 12);

        int i = userMapper.delete(wrapper);

        System.out.println("受影响的行数:" + i);
    }

    /**
     * 根据 QueryWrapper 包装的条件进行删除
     * 方法二
     */
    @Test
    public void testDelete2() {
        User user = new User();
        user.setUserName("xiaoqing");
        user.setPassword("654321");

        // 使用 QueryWrapper 包装删除条件
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);

        int i = userMapper.delete(wrapper);

        System.out.println("受影响的行数:" + i);
    }

    /**
     * DELETE
     * FROM t_user
     * WHERE id IN ( 12 , 13 , 14 , 15 );
     */
    @Test
    public void testDeleteBatchIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(12, 13, 14, 15));
        System.out.println("受影响的行数:" + i);
    }

    /***********************************自定义操作*************************************************/

    @Test
    public void testGetUserByUserName() {
        User user = userMapper.getUserByUserName("xiaoqing");
        System.out.println(user);
    }

    /***********************************AllEq 操作*************************************************/

    /**
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE password = '123' AND name = '小青' AND age IS NULL;
     */
    @Test
    public void testAllEq() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小青");
        params.put("age", null);
        params.put("password", "123");
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.allEq(params);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE password = '123' AND name = '小青';
     */
    @Test
    public void testAllEq2() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小青");
        params.put("age", null);
        params.put("password", "123");
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // null2IsNull: false,则查询参数里为null的,不会出现在WHERE条件中
        wrapper.allEq(params, false);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * SELECT id,user_name,name,age,email AS mail
     * FROM t_user
     * WHERE age = 20;
     */
    @Test
    public void testAllEq3() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小青");
        params.put("age", 20);
        params.put("password", "123");
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // params 中的参数能否作为查询条件,取决于参数与Lambda表达式中的逻辑处理的结果,
        // 如果true, 则此条件将出现在WHERE语句中
        wrapper.allEq((k, v) -> {
            return k.equals("age") || k.equals("id");
        }, params);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /***********************************比较操作*************************************************/
    /**
     * SELECT id,user_name,name,age,email AS mail
     *  FROM t_user
     *  WHERE password = '123456' AND age > 19 AND name IN ('小青','小红');
     */
    @Test
    public void testEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123456")
                .gt("age", 19)
                .in("name", "小青","小红");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /***********************************Like操作*************************************************/
    /**
     * SELECT id,user_name,name,age,email AS mail
     *  FROM t_user
     *  WHERE user_name LIKE 'xiao%' AND email LIKE '%163.com';
     */
    @Test
    public void testLike() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("user_name", "xiao")
                .likeLeft("email","163.com");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /***********************************排序操作*************************************************/
    /**
     * SELECT id,user_name,name,age,email AS mail
     *  FROM t_user
     *  WHERE id < 5 ORDER BY age DESC;
     */
    @Test
    public void testOrder() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lt("id",5)
                .orderByDesc("age");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /***********************************OR操作*************************************************/
    /**
     * SELECT id,user_name,name,age,email AS mail
     *  FROM t_user
     *  WHERE name = '小青' OR age = 20 AND password = '123';
     */
    @Test
    public void testOr() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","小青")
                .or()
                .eq("age",20)
                .eq("password","123");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /***********************************Select 指定查询字段 *************************************************/
    /**
     * SELECT id,name,age,password
     *  FROM t_user
     *  WHERE name = '小青' OR age = 20;
     */
    @Test
    public void testSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","小青")
                .or()
                .eq("age",20)
                // 指定查询的字段
                .select("id","name","age","password");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
