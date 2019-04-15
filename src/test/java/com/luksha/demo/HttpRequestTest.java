package com.luksha.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getParathasShouldReturnEmptyList() throws Exception {
        TestRestTemplate testRestTemplate = new TestRestTemplate("marko",
                "1000parathas", TestRestTemplate.HttpClientOption.ENABLE_COOKIES);
        assertThat(testRestTemplate.getForObject("http://localhost:" + port + "/paratha",
                String.class)).contains("[]");
    }
}
