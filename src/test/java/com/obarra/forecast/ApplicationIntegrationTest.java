package com.obarra.forecast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obarra.forecast.bean.Weather;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ActiveProfiles("integrationtest")
@AutoConfigureMockMvc
public class ApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void forecastIntegrationTest() throws Exception {
        mockMvc.perform(get("/weather")
                .param("day","566"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.day").value(566L));


        Path resourceDirectory = Paths.get("src","test","resources", "weathers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Weather> object = objectMapper.readValue(
                new String(Files.readAllBytes(resourceDirectory.toRealPath())
                ),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Weather.class)
        );

        String bodyString = mockMvc.perform(get("/weather/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$[1].name", Matchers.is("Optimum")))
                .andReturn().getResponse().getContentAsString();

        List<Weather> response = objectMapper
                .readValue(bodyString,
                        objectMapper
                                .getTypeFactory()
                                .constructCollectionType(List.class, Weather.class));
        Assertions.assertIterableEquals(object, response);
    }

    @Test
    public void weatherIntegrationTest() throws Exception {
        mockMvc.perform(get("/forecast/rain"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.weather.id").value(1L))
                .andExpect(jsonPath("$.maximumIntensityDay").value(3348L));

        mockMvc.perform(get("/forecast/{name}", "optimum"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.weather.id").value(3L));

        mockMvc.perform(get("/forecast/{name}", "drought"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.weather.id").value(2L));
    }
}
