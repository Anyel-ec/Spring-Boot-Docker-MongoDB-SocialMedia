package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import top.anyel.rrss.model.User;
import top.anyel.rrss.service.RestConsumerService;

@RestController
@RequestMapping("/restConsumer")
public class RestConsumerController {

    private final RestConsumerService restConsumerService;

    @Autowired
    public RestConsumerController(RestConsumerService restConsumerService) {
        this.restConsumerService = restConsumerService;
    }

    @GetMapping("/getUserAll")
    public String getUser() {
        return restConsumerService.getUserAsJson();
    }

    @GetMapping("/getUserByID/{userId}")
    public String getUserByID(@PathVariable Long userId) {
        return restConsumerService.getUserByID(userId);
    }
}