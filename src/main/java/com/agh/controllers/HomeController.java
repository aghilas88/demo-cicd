package com.agh.controllers;

import com.agh.models.AppInfos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/app-infos", method = RequestMethod.GET)
    public Mono<AppInfos> infos() {
        return Mono.just(AppInfos
                             .builder()
                             .appName("demo jenkins")
                             .appDescription("demo jenkins ...")
                             .build());
    }
}
