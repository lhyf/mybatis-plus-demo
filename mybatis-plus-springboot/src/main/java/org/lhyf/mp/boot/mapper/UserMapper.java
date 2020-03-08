package org.lhyf.mp.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lhyf.mp.boot.entity.User;
import org.lhyf.mp.boot.injectors.CommonMapper;

import java.util.List;

/****
 * @author YF
 * @date 2020-03-04 21:48
 * @desc UserMapper
 *
 **/
public interface UserMapper extends CommonMapper<User> {

    User getUserByUserName(String userName);

}
