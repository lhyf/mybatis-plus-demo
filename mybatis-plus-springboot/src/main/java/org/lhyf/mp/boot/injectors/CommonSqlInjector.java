package org.lhyf.mp.boot.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/****
 * @author YF
 * @date 2020-03-08 12:11
 * @desc CommonSqlInjector
 *
 **/
public class CommonSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        // 获取父类中的集合
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 再扩充自己定义的方法
        methodList.add(new FindAll());
        return methodList;
    }
}
