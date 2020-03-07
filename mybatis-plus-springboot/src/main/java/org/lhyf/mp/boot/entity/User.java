package org.lhyf.mp.boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/****
 * @author YF
 * @date 2020-03-04 21:45
 * @desc User
 *
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName(value = "t_user")
public class User extends Model<User> {

    // 设置ID 自增长
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;

    @TableField(select = false) // 查询时不返回该字段的值
    private String password;
    private String name;
    private Integer age;

    // 乐观锁版本
    @Version
    private Integer version;

    @TableField(value = "email") // 指定数据表中字段名
    private String mail;


    @TableField(exist = false)  // 使用此注解表明字段在数据表中不存在
    private String address; // 此字段在数据表中不存在



    public User(String userName, String password, String name, Integer age, String mail) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.mail = mail;
    }
}
