package com.obarra.forecast.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/sql/CREATE_TABLES.sql")
                .addScripts("classpath:/sql/INSERT_WEATHER_TYPE.sql",
                        "classpath:/sql/INSERT_WEATHER_DAY_RAIN.sql",
                        "classpath:/sql/INSERT_WEATHER_DAY_OPTIMUM.sql",
                        "classpath:/sql/INSERT_WEATHER_DAY_DROUGHT.sql")
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        return sessionFactoryBean.getObject();
    }
}
