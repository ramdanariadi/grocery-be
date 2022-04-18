package tunas.ecomerce.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RmqSenderConfig{

    @Bean
    public Queue queueTransaction(@Value("${queue.transaction}") String message){
        return new Queue(message, true);
    }

    @Bean
    public Queue queueMailing(@Value("${queue.mailing}") String message){
        return new Queue(message, true);
    }
}
