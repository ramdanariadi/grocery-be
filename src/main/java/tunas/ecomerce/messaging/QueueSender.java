package tunas.ecomerce.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queueTransaction;

    @Autowired
    private Queue queueMailing;

    public void sendTransaction(String order){
        rabbitTemplate.convertAndSend(this.queueTransaction.getName(), order);
    }

    public void sendEmail(String order){
        rabbitTemplate.convertAndSend(this.queueMailing.getName(), order);
    }
}
