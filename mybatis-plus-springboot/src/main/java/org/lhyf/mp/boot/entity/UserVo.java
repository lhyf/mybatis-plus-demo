package org.lhyf.mp.boot.entity;

import lombok.Data;

/****
 * @author YF
 * @date 2020-03-17 20:14
 * @desc UserVo
 *
 **/
@Data
public class UserVo {
    private Integer id;
    private String userName;

    private String password;
    private String name;
}
