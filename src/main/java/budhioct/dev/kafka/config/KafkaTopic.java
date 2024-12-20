package budhioct.dev.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic orders() {
        // Kafka topic orders with 3 partitions
        return TopicBuilder
                .name("orders")
                .partitions(3)
                .replicas(1)
                .build();
    }

}
