package com.backend.v1.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	private static final String HASH_OPS_ID_KEY = "ID";
	private static final String HASH_OPS_TOKEN_KEY = "TOKEN";

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valusOps;	

	@Resource(name = "redisTemplate")
	private HashOperations<String, String, String> hashOps;	

	public void setRedisDataByString(String Key, String Value) {
		try {
			hashOps.put(Key, HASH_OPS_ID_KEY, Key);
			hashOps.put(Key, HASH_OPS_TOKEN_KEY, Value);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public void deleteRedisData(String Key) {
		hashOps.delete(Key, HASH_OPS_ID_KEY);
		hashOps.delete(Key, HASH_OPS_TOKEN_KEY);
	}
	
	public void setRedisDataByInt(String Key, int Value) {
		try {
			valusOps.increment(Key, Value);		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void setRedisDataByLong(String Key, Long Value) {
		try {
			valusOps.increment(Key, Value);		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public String getUserIdByRedisData(String Key) {
		return hashOps.get(Key, HASH_OPS_ID_KEY);
	}
	
	public String getTokenByRedisData(String Key) {
		return hashOps.get(Key, HASH_OPS_TOKEN_KEY);
	}
	
}
