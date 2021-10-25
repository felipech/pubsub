package com.gcp.pubsub.example.pubsub.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DataTopic implements Serializable {
    private String activityId;
    private String orderNumber;
    private String eventId;


}
