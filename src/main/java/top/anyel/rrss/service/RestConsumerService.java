package top.anyel.rrss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.repository.RestConsumerRepository;

@Service
public class RestConsumerService {

    private final RestConsumerRepository restConsumerRepository;

    @Autowired
    public RestConsumerService(RestConsumerRepository restConsumerRepository ) {
        this.restConsumerRepository = restConsumerRepository;
    }

    public String getUserAsJson() {
        return restConsumerRepository.getUserAsJson();
    }

    public String getUserByID(Long userId) {
        return restConsumerRepository.getUserByID(userId);
    }


}
