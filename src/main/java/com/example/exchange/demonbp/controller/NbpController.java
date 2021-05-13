package com.example.exchange.demonbp.controller;

import com.example.exchange.demonbp.model.CurrencyObject;
import com.example.exchange.demonbp.model.Mid;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class NbpController {

    @GetMapping("currencies")
    @ResponseStatus(HttpStatus.OK)
    public List<CurrencyObject> getCurrencies() {
        String url = "https://api.nbp.pl/api/exchangerates/tables/A/?format=json";
        RestTemplate template = new RestTemplate();
        return template.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CurrencyObject>>() {
                }
        ).getBody();
    }

    @GetMapping("test/{id}") //http://localhost:8080/api/test/1
    @ResponseBody
    public String returnId(@PathVariable String id) {
        return "ID: " + id;
    }

    @GetMapping("test2") //http://localhost:8080/api/test2?id=1
    @ResponseBody
    public String returnIdParam(@RequestParam String id) {
        return "ID PARAM: " + id;
    }

    @PostMapping("exchange")
    @ResponseStatus(HttpStatus.OK)
    public Double exchange(@RequestBody ToExchange toExchange) {
        System.out.println(toExchange.getFirst());
        System.out.println(toExchange.getSecond());

        RestTemplate template = new RestTemplate();
        Mid firstMid = template.getForObject(
                "https://api.nbp.pl/api/exchangerates/rates/a/" + toExchange.getFirst(),
                Mid.class
        );

        return null;
    }

    @GetMapping("golds")
    public List<Gold> getGolds() {
        String url = "http://api.nbp.pl/api/cenyzlota/today";
        RestTemplate template = new RestTemplate();
        return template.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Gold>>() {
                }
        ).getBody();

    }
}
