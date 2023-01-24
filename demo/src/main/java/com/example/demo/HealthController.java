package com.example.demo;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/")
    public String getString(){
        logger.info("INFO .................................");
        logger.debug("DEBUG....................................");
        logger.warn("WARN.......................................");
        logger.error("ERROR.....................................");
        logger.trace("TRACE..........................................");

        logger.info("logger.isInfoEnabled() = "+logger.isInfoEnabled());
        logger.info("logger.isDebugEnabled() = "+logger.isDebugEnabled());
        logger.info("logger.isWarnEnabled() = "+logger.isWarnEnabled());
        logger.info("logger.isErrorEnabled() = "+logger.isErrorEnabled());
        logger.info("logger.isTraceEnabled() = "+logger.isTraceEnabled());

        return "OK";
    }
}
