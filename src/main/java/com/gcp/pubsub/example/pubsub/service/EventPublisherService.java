package com.gcp.pubsub.example.pubsub.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

    private final String TOPIC_NAME = "pubsubtest1";

    @Bean
    @ServiceActivator(inputChannel = "exampleOutputChannel")
    public MessageHandler messageSender(PubSubTemplate pubSubTemplate){
        return new PubSubMessageHandler(pubSubTemplate,TOPIC_NAME);

    }


}
