package top.anyel.rrss.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_USERS = "usersQueue";
    public static final String QUEUE_USER_BY_ID = "userByIdQueue";

    @Bean
    public Queue usersQueue() {
        return new Queue(QUEUE_USERS, true);
    }

    @Bean
    public Queue userByIdQueue() {
        return new Queue(QUEUE_USER_BY_ID, true);
    }
}
