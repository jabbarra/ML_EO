package com.obarra.forecast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.controller.ForecastController;
import com.obarra.forecast.service.ForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        Path resourceDirectory = Paths.get("src","test","resources", "weathers.json");


        ObjectMapper objectMapper = new ObjectMapper();
        List<Weather> object = objectMapper.readValue(
                new String(Files.readAllBytes(resourceDirectory.toRealPath())
                ),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Weather.class)
        );
        System.out.println(object);

        String bodyString = mockMvc.perform(get("/weather/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString();

        List<Weather>  response = objectMapper.readValue(bodyString, objectMapper.getTypeFactory().constructCollectionType(List.class, Weather.class)
        );

        Assertions.assertIterableEquals(object, response);
    }
}
