package org.lhyf.mp.boot.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/****
 * @author YF
 * @date 2020-03-07 22:24
 * @desc MyInterceptor
 *
 **/

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拦截方法,具体业务逻辑编写的位置
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 创建 target 对象的代理对象,目的是将当前拦截器加入到该对象中
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 属性设置
    }
}
