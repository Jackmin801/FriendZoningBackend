package com.meowmeow.dhateapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;

@SpringBootApplication
public class DhateappApplication {
	static String network = "localhost";
	/*
	@Bean
	public Random getRandom(){
		return new Random();
	}*/

	@Bean(name="UserDB")
	@Primary
	JedisConnectionFactory UserConnection(){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(network);
		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	@Bean(name="UserTemplate")
	@Primary
	public RedisTemplate<String, Object> redisTemplateUser(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(UserConnection());
		return template;
	}

	@Bean(name="ChatDB")
	JedisConnectionFactory AuthConnection(){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(network);
		jedisConnectionFactory.setPort(6479);
		return jedisConnectionFactory;
	}

	@Bean(name="ChatTemplate")
	public RedisTemplate<String, Object> redisTemplateAuth(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(AuthConnection());
		return template;
	}

	public static void main(String[] args) {
		// Set network of redis connection
		if(args.length>0) {
			network = args[0];
			System.out.println(args[0]);
		}
		SpringApplication.run(DhateappApplication.class, args);
	}

}
