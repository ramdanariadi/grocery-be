package tunas.ecomerce.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RmqSenderConfig{

    @Value("${queue.name}")
    private String message;

    @Bean
    public Queue queue(){
        return new Queue(message, true);
    }
}
