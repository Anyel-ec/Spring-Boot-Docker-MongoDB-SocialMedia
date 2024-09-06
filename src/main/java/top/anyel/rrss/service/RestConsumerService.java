package top.anyel.rrss.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.rrss.config.RabbitMQConfig;
import top.anyel.rrss.shared.utils.logger.CustomLoggerFactory;
import top.anyel.rrss.shared.utils.logger.ICustomLogger;

import java.util.UUID;

@Service
public class RestConsumerService {
    @Autowired
    RabbitTemplate rabbitTemplate;



    // Solicitar todos los usuarios
    public String requestAllUsers() {
        String correlationId = UUID.randomUUID().toString();
        String replyQueue = "replyQueue";
        String requestQueue = RabbitMQConfig.QUEUE_USERS;

        rabbitTemplate.execute(channel -> {
            // Declarar la cola de respuestas si no existe
            channel.queueDeclare("replyQueue", true, false, false, null);
            return null;
        });


        MessageProperties props = new MessageProperties();
        props.setCorrelationId(correlationId);
        props.setReplyTo(replyQueue);
        props.setDeliveryMode(MessageDeliveryMode.PERSISTENT);

        String requestMessage = "{\"request\": \"getAllUsers\"}";
        Message message = new Message(requestMessage.getBytes(), props);

        rabbitTemplate.send(requestQueue, message);

        // Esperar respuesta o manejar diferido
        Message response = rabbitTemplate.receive(replyQueue, 5000);

        if (response != null && correlationId.equals(response.getMessageProperties().getCorrelationId())) {
            return new String(response.getBody());
        } else {
            // Almacenar en la cola si Django está caído
            return "Consulta enviada. Los resultados se devolverán cuando Django esté activo.";
        }
    }

    // Solicitar usuario por ID
    public String requestUserData(Long userId) {
        String correlationId = UUID.randomUUID().toString();
        String replyQueue = "replyQueue";
        String requestQueue = RabbitMQConfig.QUEUE_USER_BY_ID;

        rabbitTemplate.execute(channel -> {
            // Declarar la cola de respuestas si no existe
            channel.queueDeclare("replyQueue", true, false, false, null);
            return null;
        });


        MessageProperties props = new MessageProperties();
        props.setCorrelationId(correlationId);
        props.setReplyTo(replyQueue);
        props.setDeliveryMode(MessageDeliveryMode.PERSISTENT);

        String requestMessage = String.format("{\"request\": \"getUserById\", \"userId\": %d}", userId);
        Message message = new Message(requestMessage.getBytes(), props);

        rabbitTemplate.send(requestQueue, message);

        Message response = rabbitTemplate.receive(replyQueue, 5000);

        if (response != null && correlationId.equals(response.getMessageProperties().getCorrelationId())) {
            return new String(response.getBody());
        } else {
            return "Consulta enviada. Los resultados se devolverán cuando Django esté activo.";
        }
    }
}
