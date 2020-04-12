package com.obarra.forecast.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@TestPropertySource(locations = "classpath:application.properties")
@ActiveProfiles("integrationtest")
class DayMapperTest {

    @Autowired
    private DayMapper dayMapper;

    @Test
    void countPeriodsOfWeatherType() {
        Long quantityPeriods  = dayMapper.countPeriodsOfWeatherType(1L);
        assertEquals(Long.valueOf(3L), quantityPeriods);
    }

    @Test
    void findMaximumRainIntensityDay() {
        Long maximumRainIntensityDay = dayMapper.findMaximumRainIntensityDay();
        assertEquals(Long.valueOf(3348), maximumRainIntensityDay);
    }
}