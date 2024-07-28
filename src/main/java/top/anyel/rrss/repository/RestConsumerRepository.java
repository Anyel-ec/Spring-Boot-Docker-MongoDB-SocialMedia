package top.anyel.rrss.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import top.anyel.rrss.config.AppEnvironment;
@Repository
public class RestConsumerRepository {

    private final String BASE_URL;
    private final String API_USER;

    private final RestTemplate restTemplate;

    @Autowired
    public RestConsumerRepository(AppEnvironment appEnvironment, RestTemplate restTemplate) {
        this.BASE_URL = appEnvironment.getBaseUrl();
        this.API_USER = appEnvironment.getApiUserPath();
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        RestConsumerRepository restConsumerRepository = new RestConsumerRepository(new AppEnvironment(), new RestTemplate());
        System.out.println(restConsumerRepository.getUserAsJson());
        System.out.println(restConsumerRepository.getUserByID(4L));
    }

    public String getUserAsJson() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + API_USER, String.class);
        return response.getBody();
    }

    public String getUserByID(Long userId) {
        return restTemplate.getForObject(BASE_URL + API_USER + "/" + userId, String.class);
    }
}