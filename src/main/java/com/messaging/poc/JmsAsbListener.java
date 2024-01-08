package com.messaging.poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
@Slf4j
public class JmsAsbListener {

    @JmsListener(destination = "${azure.servicebus.topic-name}",
            containerFactory = "topicJmsListenerContainerFactory",
            subscription = "${azure.servicebus.subscription-name}")
    public void receiveMsg(String message) {
        log.info("Received message in ASB topic-1 {} ", message);
    }
}
