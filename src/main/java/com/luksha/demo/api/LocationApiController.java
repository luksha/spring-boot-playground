package com.luksha.demo.api;

import com.luksha.demo.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping(path = "/location", produces = "application/json")
@CrossOrigin(origins = "*")
public class LocationApiController {

    private static final Logger logger = LoggerFactory.getLogger(LocationApiController.class);

    @Autowired
    private WebClient webClient;

    @GetMapping(produces = "application/json")
    public Location getLocation() {
        RestTemplate restTemplate = new RestTemplate();
        String locationApi = "http://ip-api.com/json";
        Location location = restTemplate.getForObject(locationApi, Location.class);
        logger.info(location.toString());
        return location;
    }

    @GetMapping(produces = "application/json", value = "/reactive")
    public Mono<Location> getLocationReactive() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(Location.class)
                .timeout(Duration.ofSeconds(15));
    }
}