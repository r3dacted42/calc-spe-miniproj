package com.r3dacted42.scicalc;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void addTest() throws Exception {
        mockMvc.perform(get("/api/add?a=5.5&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(5.5 + 2));
    }

    @Test
    @Order(2)
    public void subtractTest() throws Exception {
        mockMvc.perform(get("/api/sub?a=5.5&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(5.5 - 2));
    }

    @Test
    @Order(3)
    public void multiplyTest() throws Exception {
        mockMvc.perform(get("/api/mul?a=5.2&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(5.2 * 2));
    }

    @Test
    @Order(4)
    public void divideTest() throws Exception {
        mockMvc.perform(get("/api/div?a=5&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(5 / 2));
    }

    @Test
    @Order(5)
    public void sqrtTest() throws Exception {
        mockMvc.perform(get("/api/sqrt?a=5"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(Math.sqrt(5)));
    }

    @Test
    @Order(6)
    public void factorialTest() throws Exception {
        mockMvc.perform(get("/api/fact?a=5"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(120));
    }

    @Test
    @Order(7)
    public void lnTest() throws Exception {
        mockMvc.perform(get("/api/ln?a=5"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(Math.log(5)));
    }

    @Test
    @Order(8)
    public void powTest() throws Exception {
        mockMvc.perform(get("/api/pow?a=5&b=2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(Math.pow(5, 2)));
    }
}
