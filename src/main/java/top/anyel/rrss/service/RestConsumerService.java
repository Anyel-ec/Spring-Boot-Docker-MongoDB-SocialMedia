package top.anyel.rrss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.repository.RestConsumerRepository;
import top.anyel.rrss.shared.utils.logger.CustomLoggerFactory;
import top.anyel.rrss.shared.utils.logger.ICustomLogger;

@Service
public class RestConsumerService {

    private final RestConsumerRepository restConsumerRepository;
    private final ICustomLogger logger;

    @Autowired
    public RestConsumerService(RestConsumerRepository restConsumerRepository, CustomLoggerFactory loggerFactoryService) {
        this.logger = loggerFactoryService.getLogger(RestConsumerRepository.class);
        this.restConsumerRepository = restConsumerRepository;
    }

    public String getUserAsJson() {
        logger.logInfo("Requesting all users of service");
        return restConsumerRepository.getUserAsJson();
    }

    public String getUserByID(Long userId) {
        logger.logInfo("Requesting user with ID: " + userId + " OF SERVICE");
        return restConsumerRepository.getUserByID(userId);
    }
}
