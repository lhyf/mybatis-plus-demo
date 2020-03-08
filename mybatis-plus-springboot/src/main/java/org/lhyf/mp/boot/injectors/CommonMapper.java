package org.lhyf.mp.boot.injectors;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/****
 * @author YF
 * @date 2020-03-08 12:10
 * @desc CommonMapper
 *
 **/
public interface CommonMapper<T> extends BaseMapper<T> {

    List<T> findAll();
}
