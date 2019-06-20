package org.tektutor;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaSubscriberConfig {
 
    @Bean
    public ConsumerFactory<Integer, Object> consumerFactory() {
    	
        HashMap<String, Object> props = new HashMap<>();
        
        props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "3.84.31.181:9092" );
        props.put( ConsumerConfig.GROUP_ID_CONFIG, "UPDATE_SHIPPING_ADDRESS" );
        props.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props);
        
    }
 
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, Object> kafkaListenerContainerFactory() {
    
        ConcurrentKafkaListenerContainerFactory<Integer, Object> factory
          = new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setConsumerFactory(consumerFactory());
        
        return factory;
        
    }
}
