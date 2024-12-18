package budhioct.dev.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerApp {

    /**
     * Mengirim data ke Message Broker
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // HOST-CONSUMER:PORT-CONSUMER
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // TYPE JAVA TO TYPE KAFKA
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 1000000; i++) {
            ProducerRecord<String, String> message = new ProducerRecord<>("helloworld", Integer.toString(i), "Hello " + i); // ProducerRecord(String topic, K key, V value)
            producer
                    .send(message) // Future<RecordMetadata> send(ProducerRecord<K, V> record) // Asynchronous send, tidak di tunggu
                    .get(); // V get() // akan di tungguin sampai proses selesai di kafka
        }
        producer.close();

    }

}
