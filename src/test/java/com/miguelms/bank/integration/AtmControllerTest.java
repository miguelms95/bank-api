package com.miguelms.bank.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class AtmControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void atmTestGetAccountsPinOK() throws Exception {
        this.mockMvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .param("cardNumber","1111222233334444")
                .param("pin", "1234"))
                .andExpect(status().isOk());
    }

    @Test
    public void atmTestGetAccountsPinERROR() throws Exception {
        this.mockMvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .param("cardNumber","1111222233334444")
                .param("pin", "9999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void atmTestGetAccountsCardNotExists() throws Exception {
        this.mockMvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .param("cardNumber","123")
                .param("pin", "9999"))
                .andExpect(status().isNotFound());
    }
}
