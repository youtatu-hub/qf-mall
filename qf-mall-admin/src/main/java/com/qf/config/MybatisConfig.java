package com.qf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author youta
 * @version v1.0
 * @project qf-mall
 * @package com.qf.config
 * @company 千锋教育
 * @date 2024/7/2 21:56
 *
 * Mybatis配置类
 */
@Configuration
@EnableTransactionManagement  // 开启事务
@MapperScan("com.qf.modules.mapper")
public class MybatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
}
