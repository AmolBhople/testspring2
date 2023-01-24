package com.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {
    Logger logger = LoggerFactory.getLogger(HealthController.class);
    @Autowired
    private Producer1 producer1;

    @GetMapping("/")
    public String getString(){
        IntStream.rangeClosed(1, 10).forEach( i-> {
            logger.info("INFO .................................");
            logger.debug("DEBUG....................................");
            logger.warn("WARN.......................................");
            logger.error("ERROR.....................................");
            logger.trace("TRACE..........................................");

            logger.info("logger.isInfoEnabled() = " + logger.isInfoEnabled());
            logger.info("logger.isDebugEnabled() = " + logger.isDebugEnabled());
            logger.info("logger.isWarnEnabled() = " + logger.isWarnEnabled());
            logger.info("logger.isErrorEnabled() = " + logger.isErrorEnabled());
            logger.info("logger.isTraceEnabled() = " + logger.isTraceEnabled());
        });
        return "OK";
    }

    @GetMapping("/{number}")
    public String getString(@PathVariable int number){
        logger.info("INFO ................................."+number);
        return "OK =>"+number;
    }

    @GetMapping("/kafka/{message}")
    public String sendDataToKafka(@PathVariable String message){
        producer1.sendMessage("New message From Controller = >"+message);
        //IntStream.rangeClosed(1,100).forEach(number -> producer1.sendMessage(" number = "+number));
        return "OK";
    }


    @GetMapping("/kafka")
    public String sendDataToKafka(){
        logger.info("Sending Messages to Producer.......");

        producer1.sendMessage("NewMesageFromController");
        IntStream
                .rangeClosed(1,100)
                .forEach(number -> producer1.sendMessage(" number = "+number));
        return "OK";
    }
}
