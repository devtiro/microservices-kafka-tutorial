package com.devtiro.book.publisher.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("production")
public class KafkaConfig {

    @Bean
    public NewTopic booksPublishedTopic(final KafkaConfigProps kafkaConfigProps) {
        return TopicBuilder.name(kafkaConfigProps.getTopic())
        .partitions(10)
        .replicas(1)
        .build();    }
}
