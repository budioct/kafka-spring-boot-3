package budhioct.dev.kafka.producer;

import budhioct.dev.kafka.dto.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Book> kafkaTemplate;

    public void sendMessage(Book book) throws ExecutionException, InterruptedException {
        // log.info("Message sent to Kafka topic orders: {}", book);
        kafkaTemplate
                .send("orders", book)
                .get();
    }

}
