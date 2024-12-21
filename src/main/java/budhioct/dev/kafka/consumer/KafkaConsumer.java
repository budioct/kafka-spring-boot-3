package budhioct.dev.kafka.consumer;

import budhioct.dev.kafka.dto.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    //@KafkaListener(topics = "orders", groupId = "liverpool")
    public void receiveMessage(String message) {
        //log.info(format("Message sent to topic orders:: %s", message));
        log.info("Message from Kafka topic orders: {}", message);
    }

    @KafkaListener(topics = "orders", groupId = "liverpool")
    public void receiveJsonMessage(Book book) {
        // log.info("Message from Kafka topic orders: {}", book.toString());
    }

}
