package com.luksha.demo;

import com.luksha.demo.api.ParathaApiController;
import com.luksha.demo.data.ParathaRepo;
import com.luksha.demo.domain.Paratha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ParathaApiController.class)
public class ParathaApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParathaRepo repo;

    @Test
    public void getParathasApiWithoutAuthShouldReturnUnauthorized() throws Exception {
        when(repo.findAll()).thenReturn(Arrays.asList(new Paratha(1L, "test", new Date())));
        mockMvc.perform(get("/paratha")).andExpect(status().isUnauthorized());
    }

    @Test
    public void getParathasApiShouldReturnList() throws Exception {
        when(repo.findAll()).thenReturn(Arrays.asList(new Paratha(1L, "test", new Date())));
        mockMvc.perform(get("/paratha")
                .with(user("marko").password("1000parathas")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("test")));
    }
}