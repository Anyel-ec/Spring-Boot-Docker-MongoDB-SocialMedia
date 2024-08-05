package top.anyel.rrss.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import top.anyel.rrss.config.AppEnvironment;
import top.anyel.rrss.shared.utils.logger.CustomLoggerFactory;
import top.anyel.rrss.shared.utils.logger.ICustomLogger;

@Repository
public class RestConsumerRepository {

    private final String BASE_URL;
    private final String API_USER;

    private final RestTemplate restTemplate;
    private final ICustomLogger logger;

    @Autowired
    public RestConsumerRepository(AppEnvironment appEnvironment, RestTemplate restTemplate, CustomLoggerFactory loggerFactoryService) {
        this.BASE_URL = appEnvironment.getBaseUrl();
        this.API_USER = appEnvironment.getApiUserPath();
        this.restTemplate = restTemplate;
        this.logger = loggerFactoryService.getLogger(RestConsumerRepository.class);
    }

    public String getUserAsJson() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + API_USER + '/', String.class);
            logger.logInfo("REST TEMPLATE RESPONSE: " + response.getBody());
            return response.getBody();
        } catch (RestClientException e) {
            logger.logError("Error retrieving users", e);
            return "{\"error\":\"Error retrieving users\"}";
        }
    }

    public String getUserByID(Long userId) {
        logger.logInfo("Requesting user with ID: " + userId);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + API_USER + "/" + userId + "/", String.class);
            logger.logInfo("REST TEMPLATE RESPONSE: " + response.getBody());
            return response.getBody();
        } catch (RestClientException e) {
            logger.logError("Error retrieving user with ID: " + userId, e);
            return "{\"error\":\"Error retrieving user with ID: " + userId + "\"}";
        }
    }
}
