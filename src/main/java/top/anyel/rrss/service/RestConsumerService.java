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


    // Consumer the service of RestConsumerRepository
    @Autowired
    public RestConsumerService(RestConsumerRepository restConsumerRepository, CustomLoggerFactory loggerFactoryService) {
        this.logger = loggerFactoryService.getLogger(RestConsumerRepository.class);
        try {
            this.restConsumerRepository = restConsumerRepository;
        }
        catch (Exception e) {
            logger.logError("Error creating RestConsumerService: " + e.getMessage());
            throw e;
        }
    }




















    // get user using consumer rest
    public String getUserAsJson() {
        try{
        logger.logInfo("Requesting all users of service");
        return restConsumerRepository.getUserAsJson();
        }
        catch (Exception e) {
            logger.logError("Error getting all users: " + e.getMessage());
            throw e;
        }
    }











    public String getUserByID(Long userId) {
        logger.logInfo("Requesting user with ID: " + userId + " OF SERVICE");
        return restConsumerRepository.getUserByID(userId);
    }
}
