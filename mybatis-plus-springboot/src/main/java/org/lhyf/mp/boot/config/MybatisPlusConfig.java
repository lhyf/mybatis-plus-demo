package org.lhyf.mp.boot.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.lhyf.mp.boot.handler.MyMetaObjectHandler;
import org.lhyf.mp.boot.injectors.CommonSqlInjector;
import org.lhyf.mp.boot.plugins.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/****
 * @author YF
 * @date 2020-03-07 10:11
 * @desc MybatisPlusConfig
 *
 **/
@Configuration
// 设置Mapper 扫描的包
@MapperScan(basePackages = "org.lhyf.mp.boot.mapper")
public class MybatisPlusConfig {

    /**
     * 配置分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 配置自定义插件
     *
     * @return
     */
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    /**
     * 配置SQL 分析插件
     *
     * @return
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        List<ISqlParser> list = new ArrayList<>();
        // 全表更新, 删除的阻断器
        list.add(new BlockAttackSqlParser());

        SqlExplainInterceptor interceptor = new SqlExplainInterceptor();
        interceptor.setSqlParserList(list);
        return interceptor;
    }

    /**
     * 配置性能分析插件(生产环境不建议使用)
     *
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor interceptor = new PerformanceInterceptor();
        // 100 ms ,执行时间超过后 抛出异常
        interceptor.setMaxTime(100);
        // 对输出SQL做格式化
        interceptor.setFormat(true);
        return interceptor;
    }

    /**
     * 配置乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        OptimisticLockerInterceptor interceptor = new OptimisticLockerInterceptor();


        return interceptor;
    }

    /**
     * 注入自定义SQL生成器
     *
     * @return
     */
    @Bean
    public CommonSqlInjector commonSqlInjector() {
        return new CommonSqlInjector();
    }

    @Bean
    public MyMetaObjectHandler myMetaObjectHandler(){
        return new MyMetaObjectHandler();
    }
}
