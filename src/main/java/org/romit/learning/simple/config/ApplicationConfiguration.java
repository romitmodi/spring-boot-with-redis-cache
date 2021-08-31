package org.romit.learning.simple.config;

import org.romit.learning.simple.entity.Invoice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RedisConnectionFactory getRedisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Invoice> getRedisTemplate() {
        RedisTemplate<String, Invoice> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getRedisConnectionFactory());
        return redisTemplate;
    }
}
