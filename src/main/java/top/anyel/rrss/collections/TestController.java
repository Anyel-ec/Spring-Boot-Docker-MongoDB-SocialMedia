package top.anyel.rrss.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anyel.rrss.repository.RestConsumerRepository;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final RestConsumerRepository restConsumerRepository;

    @Autowired
    public TestController(RestConsumerRepository restConsumerRepository) {
        this.restConsumerRepository = restConsumerRepository;
    }

    @GetMapping("/send/all")
    public ResponseEntity<String> sendTestMessage() {
        restConsumerRepository.sendTestMessageToUsersQueue();
        return ResponseEntity.ok("Test message users all sent to RabbitMQ");
    }

    @GetMapping("/send/id")
    public ResponseEntity<String> sendTestMessageById() {
        restConsumerRepository.sendTestMessageToUserByIdQueue();
        return ResponseEntity.ok("Test message users by id sent to RabbitMQ");
    }
}