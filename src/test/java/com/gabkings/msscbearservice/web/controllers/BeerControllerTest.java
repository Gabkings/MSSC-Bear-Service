package com.gabkings.msscbearservice.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabkings.msscbearservice.web.model.BeerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        BeerDto.builder()
                .beerName("Tusker")
                .id(UUID.randomUUID())
                .version(1)
                .upc(1L)
                .quantityOnHand(23)
                .price(BigDecimal.valueOf(123.00))
                .createdOn(OffsetDateTime.now())
                .build();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .price(BigDecimal.valueOf(200))
                .beerName("Task2")
                .quantityOnHand(30)
                .createdOn(OffsetDateTime.now())
                .version(12)
                .upc(23L).build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateBeerDetails() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeerById() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}