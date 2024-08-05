package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.anyel.rrss.service.RestConsumerService;
import top.anyel.rrss.shared.utils.logger.CustomLoggerFactory;
import top.anyel.rrss.shared.utils.logger.ICustomLogger;

@RestController
@RequestMapping("/restConsumer")
public class RestConsumerController {

    private final RestConsumerService restConsumerService;
    private final ICustomLogger logger;

    @Autowired
    public RestConsumerController(RestConsumerService restConsumerService, CustomLoggerFactory loggerFactoryService) {
        this.restConsumerService = restConsumerService;
        this.logger = loggerFactoryService.getLogger(RestConsumerController.class);
    }

    @GetMapping("/getUserAll")
    public String getUser() {
        logger.logInfo("Requesting all users of controller");
        return restConsumerService.getUserAsJson();
    }

    @GetMapping("/getUserByID/{userId}")
    public String getUserByID(@PathVariable Long userId) {
        logger.logInfo("Requesting user with ID: " + userId);
        return restConsumerService.getUserByID(userId);
    }
}
