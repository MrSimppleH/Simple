package com.computer.campaign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author Mr.Huang
 * @create 2020-05-20 15:04
 * 自定义缓存管理器和自定义序列化器
 */
@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(objectJackson2JsonRedisSerializer);//使用json序列化器
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
    @Bean
    //自定义缓存处理器参数传入上面方法
    public RedisCacheManager myRedisCacheManager(RedisTemplate<Object, Object> redisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);//开启前缀
        return redisCacheManager;
    }
}
