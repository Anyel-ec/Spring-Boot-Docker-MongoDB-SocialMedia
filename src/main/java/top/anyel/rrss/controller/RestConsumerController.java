package top.anyel.rrss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getAllUsers")
    public ResponseEntity<String> getAllUsers() {
        logger.logInfo("Requesting all users from service");
        String response = restConsumerService.requestAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUserByID/{userId}")
    public ResponseEntity<String> getUserByID(@PathVariable Long userId) {
        logger.logInfo("Requesting user with ID: " + userId);
        String response = restConsumerService.requestUserData(userId);
        return ResponseEntity.ok(response);
    }
}
