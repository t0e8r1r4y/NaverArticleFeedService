package com.myservice.config;


import com.myservice.component.FeedMessageConsumer;
import com.myservice.domain.feedmessage.dto.FeedMessageDto;
import com.myservice.service.ArticleFeedService;
import com.myservice.service.EmailService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConsumerConfig {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Value(value = "${spring.kafka.my.push.topic.group}")
  private String groupId;

  private final ArticleFeedService articleFeedService;

  private final EmailService emailService;

  @Bean
  public ConsumerFactory<String, FeedMessageDto> consumerFactory() {
    JsonDeserializer<FeedMessageDto> deserializer = new JsonDeserializer<>(FeedMessageDto.class);
    deserializer.setRemoveTypeHeaders(false);
    deserializer.addTrustedPackages("*");
    deserializer.setUseTypeMapperForKey(true);

    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
    configMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    return new DefaultKafkaConsumerFactory<>(configMap,new StringDeserializer(),deserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, FeedMessageDto> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, FeedMessageDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.getContainerProperties().setAckMode( AckMode.MANUAL );
    factory.setConcurrency(3);
    factory.getContainerProperties().setMessageListener(new FeedMessageConsumer(articleFeedService,
        emailService));
    factory.getContainerProperties().setPollTimeout(5000);

    return factory;
  }
}
