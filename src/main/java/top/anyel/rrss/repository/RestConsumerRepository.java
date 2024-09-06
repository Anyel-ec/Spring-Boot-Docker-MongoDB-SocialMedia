package top.anyel.rrss.repository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import top.anyel.rrss.config.AppEnvironment;
import top.anyel.rrss.config.RabbitMQConfig;
import top.anyel.rrss.shared.utils.logger.CustomLoggerFactory;
import top.anyel.rrss.shared.utils.logger.ICustomLogger;

@Repository
public class RestConsumerRepository {

    private final String BASE_URL;
    private final String API_USER;

    private final RestTemplate restTemplate;
    private final ICustomLogger logger;
    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public RestConsumerRepository(AppEnvironment appEnvironment, RestTemplate restTemplate, CustomLoggerFactory loggerFactoryService, RabbitTemplate rabbitTemplate) {
        this.BASE_URL = appEnvironment.getBaseUrl();
        this.API_USER = appEnvironment.getApiUserPath();
        this.restTemplate = restTemplate;
        this.logger = loggerFactoryService.getLogger(RestConsumerRepository.class);
        this.rabbitTemplate = rabbitTemplate;
    }

    public String getUserAsJson() {
        try {
            String url = BASE_URL + API_USER ;
            logger.logInfo("Making request to URL: " + url);

            // Hacer la solicitud al servicio REST
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            String jsonResponse = response.getBody();
            logger.logInfo("REST TEMPLATE RESPONSE: " + jsonResponse);

            // Enviar mensaje a la cola de RabbitMQ
            assert jsonResponse != null;
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_USERS, jsonResponse);

            return jsonResponse;
        } catch (RestClientException e) {
            logger.logError("Error retrieving users", e);
            return "{\"error\":\"Error retrieving users\"}";
        }
    }


    public String getUserByID(Long userId) {
        logger.logInfo("Requesting user with ID: " + userId);
        try {
            // Hacer la solicitud al servicio REST
            ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + API_USER + "/" + userId + "/", String.class);
            String jsonResponse = response.getBody();
            logger.logInfo("REST TEMPLATE RESPONSE: " + jsonResponse);

            // Enviar mensaje a la cola de RabbitMQ
            assert jsonResponse != null;
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_USER_BY_ID, jsonResponse);

            return jsonResponse;
        } catch (RestClientException e) {
            logger.logError("Error retrieving user with ID: " + userId, e);
            return "{\"error\":\"Error retrieving user with ID: " + userId + "\"}";
        }
    }


    public void sendTestMessageToUsersQueue() {
        String testMessage = "Test message for Django consumer";
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_USERS, testMessage);
        System.out.println("Sent message to usersQueue: " + testMessage);
    }

    public void sendTestMessageToUserByIdQueue() {
        String testMessage = "Test message for Django consumer by ID";
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_USER_BY_ID, testMessage);
        System.out.println("Sent message to userByIdQueue: " + testMessage);
    }
}
