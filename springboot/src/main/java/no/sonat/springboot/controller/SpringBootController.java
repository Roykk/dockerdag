package no.sonat.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SpringBootController {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${nodeapp.endpoint}")
    private String endpoint = "http://localhost:8080";


    @RequestMapping("/count")
    public String home() {
        try{
            restTemplate.getForObject(endpoint+ "/nodeInsert", String.class);
            return restTemplate.getForObject(endpoint+ "/nodeGet", String.class);

        }catch (Exception e) {
            return String.format("Could not call '%s'", endpoint);
        }
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Springboot just got pinged";
    }
}