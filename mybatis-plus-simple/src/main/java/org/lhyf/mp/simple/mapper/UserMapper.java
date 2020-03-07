package org.lhyf.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lhyf.mp.simple.entity.User;

import java.util.List;

/****
 * @author YF
 * @date 2020-03-04 21:48
 * @desc UserMapper
 *
 **/
//@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 返回所有用户
     * @return
     */
    List<User> findAll();
}
