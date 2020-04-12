package com.obarra.forecast.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DayMapperTest {
    @Autowired
    private DayMapper dayMapper;

    @Test
    void countPeriodsOfWeatherType() {
        dayMapper.countPeriodsOfWeatherType(1L);
    }

    @Test
    void findMaximumRainIntensityDay() {
    }
}