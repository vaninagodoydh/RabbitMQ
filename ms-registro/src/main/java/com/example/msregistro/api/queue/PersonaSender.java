package com.example.msregistro.api.queue;

import com.example.msregistro.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonaSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue personaQueue;

    public void send(Persona persona) {
        this.rabbitTemplate.convertAndSend(this.personaQueue.getName(), persona);
    }


}
