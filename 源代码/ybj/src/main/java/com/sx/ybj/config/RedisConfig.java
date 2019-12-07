package com.sx.ybj.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @program: ybj
 * @description: redis_json转换
 * @author: lwx
 * @create: 2019-05-31 15:24
 */
@Configuration
public class RedisConfig {

//@Bean
//    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
//    RedisSerializer stringSerializer = new StringRedisSerializer();
//    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//    ObjectMapper om = new ObjectMapper();
//    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
//    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//    jackson2JsonRedisSerializer.setObjectMapper(om);
//    redisTemplate.setKeySerializer(stringSerializer);
//    redisTemplate.setHashKeySerializer(stringSerializer);
//
//    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//    CacheManager cacheManager = new RedisCacheManager(redisTemplate);
//    return cacheManager;
//
//}


@Bean

    public RedisTemplate<Object,Object> redisTemplate(
         RedisConnectionFactory redisConnectionFactory)throws UnknownHostException{
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> serializer=new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
  @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object,Object> redisTemplate){
    RedisCacheManager cacheManager=new RedisCacheManager(redisTemplate);
    cacheManager.setUsePrefix(true);
    return cacheManager;
  }

}