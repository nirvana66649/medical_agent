package com.laioffer.config;


import dev.langchain4j.community.store.embedding.redis.RedisEmbeddingStore;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddingStoreConfig {
    @Autowired
    private EmbeddingModel embeddingModel;
    @Bean
    public EmbeddingStore<TextSegment> embeddingStore(){
        return RedisEmbeddingStore.builder()
                .host("127.0.0.1")
                .port(6379)
                .indexName("medical_index")
                .dimension(embeddingModel.dimension())
               .build();
    }

}
