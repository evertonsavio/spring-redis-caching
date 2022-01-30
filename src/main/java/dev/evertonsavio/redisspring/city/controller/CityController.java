package dev.evertonsavio.redisspring.city.controller;

import dev.evertonsavio.redisspring.city.dto.City;
import dev.evertonsavio.redisspring.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("{zipCode}")
    public Mono<City> getCity(@PathVariable String zipCode){
        return this.cityService.getCity(zipCode);
    }

    @GetMapping("clear/{zipcode}")
    public void putCity(@PathVariable String zipcode){
        this.cityService.clearCity(zipcode);
    }

}
