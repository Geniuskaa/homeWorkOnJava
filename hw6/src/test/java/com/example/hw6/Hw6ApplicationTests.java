package com.example.hw6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class Hw6ApplicationTests  {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assertions.assertNotNull(servletContext);
        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webApplicationContext.getBean("calculator"));
    }
    @Test
    public void sumTest() throws Exception {
        this.mockMvc.perform(get("/sum?a=90&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("95"));
    }
    @Test
    public void differTest() throws Exception {
        this.mockMvc.perform(get("/minus?a=16&b=4")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("12"));
    }

    @Test
    public void multiplyTest() throws Exception {
        this.mockMvc.perform(get("/multiply?a=2&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("10"));
    }

    @Test
    public void divTest() throws Exception {
        this.mockMvc.perform(get("/div?a=15&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("3"));
    }

}

