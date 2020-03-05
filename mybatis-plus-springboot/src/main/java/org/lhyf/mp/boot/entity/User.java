package org.lhyf.mp.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;

}
