package com.gcp.pubsub.example.pubsub.service;


import com.gcp.pubsub.example.pubsub.model.DataTopic;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@MessagingGateway(defaultRequestChannel = "exampleOutputChannel")
public interface PubSubOutboundGateway {

    void sendToPubSub(String payload, @Headers Map<String, Object> headers);

}
