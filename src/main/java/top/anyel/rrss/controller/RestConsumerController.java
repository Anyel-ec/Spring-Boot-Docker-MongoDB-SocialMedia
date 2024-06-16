package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.anyel.rrss.service.RestConsumerService;

@Controller
@RequestMapping("/restConsumer")
public class RestConsumerController {

    private final RestConsumerService restConsumerService;

    @Autowired
    public RestConsumerController(RestConsumerService restConsumerService) {
        this.restConsumerService = restConsumerService;
    }

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser() {
        return restConsumerService.getUser();
    }
}