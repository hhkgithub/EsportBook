package com.esportbook.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by hhkmac on 2017/4/19.
 */

@Profile("dev")
@Configuration
@MapperScan(basePackages="com.esportbook.mapper",sqlSessionTemplateRef="sqlSessionTemplate")
public class DevDataSourceConfig extends DataSourceConfig{

    @Override
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    public DataSource dataSource() {
        System.out.println("==>>开发环境...");
        return super.dataSource();
    }

    @Override
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        return super.sqlSessionFactory(dataSource);
    }

    @Override
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return super.sqlSessionTemplate(sqlSessionFactory);
    }
}
