package com.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Producer1 {
    Logger logger = LoggerFactory.getLogger(Producer1.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message){
        StringBuilder stringBuilder = new StringBuilder(message);
        stringBuilder.append("   ");
        stringBuilder.append(LocalTime.now());
        String message1 = stringBuilder.toString();
        logger.info("Sending Message :"+message1);
        kafkaTemplate.send("test", message1);
    }
}
