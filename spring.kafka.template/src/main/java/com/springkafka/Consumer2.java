package com.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
    Logger logger = LoggerFactory.getLogger(Consumer2.class);
//    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @KafkaListener(id = "ConsumerGroup", topics = "test", concurrency = "2")
    public void listen(ConsumerRecord<String, String> cr, @Payload String foo) {
        logger.info(" => "+cr);
        logger.info("Received by Consumer-2: " + foo);
//        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }


    @KafkaListener(id = "ConsumerGroup2", concurrency = "2",
            topicPartitions = @TopicPartition(topic = "test3", partitions = {"0", "1"}))
    public void listenAnother(ConsumerRecord<String, String> cr, @Payload String foo) {
        logger.info("Received by Consumer-2: " + foo);
    }
}
