package jin.study.movie.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 12:06
 * \* Description:
 * \
 */
@Component
@EnableCaching
public class RedisConfiguration {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(host);
		jedisConnectionFactory.setPort(port);
		jedisConnectionFactory.setTimeout(timeout);
		return jedisConnectionFactory;
	}

	/**
	 * 根据方法的类，方法名和参数生成缓存的key
	 * @return key
	 */
	@Bean
	public KeyGenerator wiselyKeyGenerator(){
		return (o,method,objects) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(o.getClass().getName());
			sb.append(method.getName());
			for (Object object : objects) {
				sb.append(object.toString());
			}
			return sb.toString();
		};
	}

	@Bean
	public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
		setSerializer(template);
		template.afterPropertiesSet();
		return template;
	}

	private void setSerializer(StringRedisTemplate template) {
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate){
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		//设置缓存超时时间
//		cacheManager.setDefaultExpiration(10);
		return cacheManager;
	}

}
