package dk.nimlos.common.kafkasetup;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
    
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    @Bean
    public NewTopic moduleATopic() {
        return new NewTopic("moduleA", 1, (short) 1);
    }

    @Bean
    public NewTopic moduleBTopic() {
        return new NewTopic("moduleB", 1, (short) 1);
    }
    @Bean

    public NewTopic communicationModuleTopic() {
        return new NewTopic("communicationModule", 1, (short) 1);
    }
    @Bean
    public NewTopic byteTopic() {
        return new NewTopic("profibus", 1, (short) 1);
    }
}