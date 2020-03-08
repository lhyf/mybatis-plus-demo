package org.lhyf.mp.boot.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/****
 * @author YF
 * @date 2020-03-08 13:34
 * @desc MyMetaObjcetHandler
 *
 **/
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入数据时填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 先获取到password 的值, 再进行判断,如果为空则进行填充,不为空就不做处理
        Object password = getFieldValByName("password", metaObject);
        if (password == null) {
            setFieldValByName("password", "abc123", metaObject);
        }

    }

    /**
     * 更新数据时填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
