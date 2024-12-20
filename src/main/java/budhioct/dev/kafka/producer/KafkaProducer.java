package budhioct.dev.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) throws ExecutionException, InterruptedException {
        //log.info(format("Message sent to topic orders:: %s", message));
        log.info("Message sent to Kafka topic orders: {}", message);
        kafkaTemplate
                .send("orders", message)
                .get();
    }

}
