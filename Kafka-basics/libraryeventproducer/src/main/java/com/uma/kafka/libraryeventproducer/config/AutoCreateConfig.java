package com.uma.kafka.libraryeventproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class AutoCreateConfig {
	
	@Value("${spring.kafka.topic}")
	private String topicname;
	
	@Bean
	public NewTopic createnewtopic() {
		return TopicBuilder.name(topicname).partitions(3).replicas(3).build();
		
	}

}
