package com.example.parathaview;

import com.example.parathaview.configuration.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "paratha-cloud", configuration = FeignClientConfiguration.class)
public interface ParathaCloudClient {

    @RequestMapping("/paratha")
    List<Paratha> getParathas();
}
