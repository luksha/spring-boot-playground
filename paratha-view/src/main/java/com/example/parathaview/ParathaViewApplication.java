package com.example.parathaview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Controller
@RequestMapping(path = "/parathas-all")
@CrossOrigin(origins = "*")
public class ParathaViewApplication {

    @Autowired
    private ParathaCloudClient parathaCloudClient;

    public static void main(String[] args) {
        SpringApplication.run(ParathaViewApplication.class, args);
    }

    @RequestMapping
    public String getAllParathasView(Model model) {
        List<Paratha> parathaList =  parathaCloudClient.getParathas();
        model.addAttribute("parathas", parathaList);
        return "paratha-list";
    }

}
