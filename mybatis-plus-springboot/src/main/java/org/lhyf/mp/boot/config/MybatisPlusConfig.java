package org.lhyf.mp.boot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
