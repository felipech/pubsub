package com.gcp.pubsub.example.pubsub.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.pubsub.example.pubsub.model.DataTopic;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceForProcessingDataTopic {

    ObjectMapper objectMapper = new ObjectMapper();
    public void processingDataTopic(Message<?> pubSubMessage) {


        Map<String, Object> headers = new HashMap<>();


        for (Map.Entry<String, Object> entry : pubSubMessage.getHeaders().entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            headers.put(entry.getKey(), entry.getValue().toString());
        }

        //DataTopic dataTopic = objectMapper.convertValue(mapDataFromTopic(pubSubMessage.getPayload()), DataTopic.class) ;
        System.out.println("asdasdasdasd");


        System.out.println("asdddddddddd");

    }


    private Map<String, String> createHeadersFromTopic(MessageHeaders messageHeaders){
        Map<String, String> headers = new HashMap<>();

        for (Map.Entry<String, Object> entry : messageHeaders.entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            headers.put(entry.getKey(), entry.getValue().toString());
        }

        return headers;

    }

    private Object mapDataFromTopicGeneric(Object message) throws JsonProcessingException {

        String payloadConverted = null;
        if(message != null){
            payloadConverted = new String((byte[]) message);
        }

        return objectMapper.readValue(payloadConverted, Object.class);
    }


    //version directa no generica
    private DataTopic mapDataFromTopic(Object message) throws JsonProcessingException {

        String payloadConverted = null;
        if(message != null){
            payloadConverted = new String((byte[]) message);
        }

        return objectMapper.readValue(payloadConverted, DataTopic.class);
    }


}
