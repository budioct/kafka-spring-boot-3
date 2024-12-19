package budhioct.dev.kafka.app;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ProducerApp {

    /**
     * Mengirim data ke Message Broker (Kafka.topics)
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // HOST-CONSUMER:PORT-CONSUMER
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // TYPE JAVA TO TYPE KAFKA
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 1; i <= 5000; i++) {
            ProducerRecord<String, String> message = new ProducerRecord<>("orders", Integer.toString(i), "Hello -" + i + " " + UUID.randomUUID()); // ProducerRecord(String topic, K key, V value)
            producer
                    .send(message) // Future<RecordMetadata> send(ProducerRecord<K, V> record) // Asynchronous send. the process will not wait
                    .get(); // V get() // the process will be waited for to finish in kafka
        }
        producer.close(); // if the process is not finished, it will be closed

    }

}
