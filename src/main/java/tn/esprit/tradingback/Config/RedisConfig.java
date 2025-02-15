package tn.esprit.tradingback.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
@EnableCaching
@Configuration
public class RedisConfig {

    //   @Bean
    //   public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // Configure Jackson ObjectMapper with JavaTimeModule
    //      ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.registerModule(new JavaTimeModule());

        // Create custom GenericJackson2JsonRedisSerializer with configured ObjectMapper
    //       GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);

    //      RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
    //             .entryTtl(Duration.ofDays(1)) // Set TTL as per your needs
    //             .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
    //           .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer));

    //     return RedisCacheManager.builder(redisConnectionFactory)
    //            .cacheDefaults(cacheConfig)
    //              .build();
    //   }

    //   @Bean
    //  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //     RedisTemplate<String, Object> template = new RedisTemplate<>();
        //      template.setConnectionFactory(redisConnectionFactory);
        //    template.setKeySerializer(new StringRedisSerializer());

        // Set the custom serializer with JavaTimeModule
        //      ObjectMapper objectMapper = new ObjectMapper();
        //       objectMapper.registerModule(new JavaTimeModule());
        //     GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);

        //     template.setValueSerializer(valueSerializer);
        //      return template;
        //   }
}
