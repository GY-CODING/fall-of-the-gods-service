package org.gycoding.fallofthegods.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "org.gycoding.fallofthegods.model.database.*",
        mongoTemplateRef = "serviceMongoTemplate"
)
public class ServiceMongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Bean
    @Primary
    public MongoClient serviceMongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "serviceMongoTemplate")
    @Primary
    public MongoTemplate serviceMongoTemplate() {
        return new MongoTemplate(serviceMongoClient(), databaseName);
    }
}
