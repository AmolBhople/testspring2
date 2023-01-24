package com.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
    Logger logger = LoggerFactory.getLogger(Consumer1.class);
//    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @KafkaListener(id = "ConsumerGroup1", topics = "test1", concurrency = "3")
    public void listen(String foo) {
        logger.info("Received by Consumer-1: " + foo);
//        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }
}
