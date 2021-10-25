package com.gcp.pubsub.example.pubsub.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.pubsub.example.pubsub.model.DataTopic;
import com.gcp.pubsub.example.pubsub.service.EventPublisherService;
import com.gcp.pubsub.example.pubsub.service.PubSubOutboundGateway;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SenderPubSubController {

    @Autowired
    private PubSubOutboundGateway pubSubOutboundGateway;

    ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/sendMessage")
    public ResponseEntity<?> publishMessageGcp(@RequestBody DataTopic payload) throws JsonProcessingException {
        System.out.println("sending a message to PubSub");
/*        PubsubMessage pubsubMessage = PubsubMessage
                .newBuilder()
                .setData(ByteString.copyFromUtf8(objectMapper.writeValueAsString(payload)))
                .putAllAttributes(generateHeadersTopic())
                .build();*/

        //pubSubOutboundGateway.sendToPubSub(objectMapper.writeValueAsString(payload), "cl");
        pubSubOutboundGateway.sendToPubSub(objectMapper.writeValueAsString(payload), generateHeadersTopic());/////asdasdasd
        return new ResponseEntity<>(HttpStatus.OK);

    }

    private Map<String, Object> generateHeadersTopic(){
        Map<String, Object> headersTopic = new HashMap<>();

        headersTopic.put("country","cl");

        return headersTopic;
    }

}
