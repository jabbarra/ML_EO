package com.obarra.forecast.mapper;

import com.obarra.forecast.bean.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@TestPropertySource(locations = "classpath:application.properties")
@ActiveProfiles("integrationtest")
class WeatherMapperTest {

    @Autowired
    private WeatherMapper weatherMapper;
    private Weather expectedWeather;

    @BeforeEach
    void setUp() {
        expectedWeather = new Weather();
        expectedWeather.setName("Rain");
        expectedWeather.setId(1L);
    }

    @Test
    void findWeathers() {
        List<Weather> result = weatherMapper.findWeathers();
        assertEquals(3, result.size());
    }

    @Test
    void findById() {
        Weather result = weatherMapper.findById(1L);
        assertEquals(expectedWeather, result);
    }

    @Test
    void findByDay() {
        Weather result = weatherMapper.findByDay(566L);
        assertEquals(expectedWeather, result);
    }
}