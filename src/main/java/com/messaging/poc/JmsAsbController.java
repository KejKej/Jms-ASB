package com.messaging.poc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asb")
@RequiredArgsConstructor
@Slf4j
public class JmsAsbController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("")
    public ResponseEntity<Void> sendMessage() {
        try {

            String message = "My first ASB message";

            jmsTemplate.convertAndSend("topic-1", message);

            log.info("Message {} sent to topic-1", message);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
