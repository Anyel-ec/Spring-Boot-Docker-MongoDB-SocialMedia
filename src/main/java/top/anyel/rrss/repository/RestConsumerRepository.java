package top.anyel.rrss.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import top.anyel.rrss.config.constants.AppEnvironment;
@Repository
public class RestConsumerRepository {

    private final String BASE_URL;
    private final String API_USER;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public RestConsumerRepository(AppEnvironment appEnvironment) {
        this.BASE_URL = appEnvironment.getBaseUrl();
        this.API_USER = appEnvironment.getApiUserPath();
    }

    public static void main(String[] args) {
        RestConsumerRepository restConsumerRepository = new RestConsumerRepository(new AppEnvironment());
        System.out.println(restConsumerRepository.getUser());
    }

    public String getUser() {
        return restTemplate.getForObject(BASE_URL + API_USER, String.class);
    }
}
