package org.lhyf.mp.boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lhyf.mp.boot.emun.SexEnum;

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

    // 查询时不返回该字段的值
    // 插入数据时,自动填充
    @TableField(select = false,fill = FieldFill.INSERT)
    private String password;
    private String name;

    // 性别,枚举类型
    private SexEnum sex;

    private Integer age;

    // 乐观锁版本
    @Version
    private Integer version;

    // 逻辑删除字段 1:删除 0:未删除
    @TableLogic
    private Integer deleted;

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
