package budhioct.dev.kafka.rest;

import budhioct.dev.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping(
            //produces = MediaType.APPLICATION_JSON_VALUE,
            //consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic orders");

        /**
         * if you want to print @RequestBody String message will output:
         * // return ResponseEntity.ok("Message sent to topic orders: " + message);
         * Message sent to topic orders: {
         *     "message" : "asek"
         * }
         */
    }

}
