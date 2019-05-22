package com.ch.util;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
/**
 * Redis 默认是单机环境使用的。
 *数据量较大时需要shard（多机环境），这个时候要用ShardedJedis。 
 *ShardedJedis是基于一致性哈希算法实现的分布式Redis集群客户端
 * @author Administrator *
 */
public class RedisConnection {
	 public Jedis jedis;//非切片额客户端连接
	 public JedisPool jedisPool;//非切片连接池
	 public ShardedJedis shardedJedis;//切片额客户端连接
	 public ShardedJedisPool shardedJedisPool;//切片连接池
	     /**
	      * Redis 默认是单机环境使用的。 数据量较大时需要shard（多机环境），
	      * 这个时候要用ShardedJedis。 ShardedJedis是基于一致性哈希算法实
	      * 现的分布式Redis集群客户端
	      */
	    public RedisConnection() 
	    { 
	        initialPool(); 
	        initialShardedPool(); 
	        shardedJedis = shardedJedisPool.getResource(); 
	        jedis = jedisPool.getResource(); 
	        
	        
	    } 
	 
	    /**
	     * 初始化非切片池
	     */
	    public void initialPool() 
	    { 
	        // 池基本配置 
	        JedisPoolConfig config = new JedisPoolConfig(); 
	        config.setMaxTotal(20); //设置最大连接数
	        config.setMaxIdle(5);  // 设置最大空闲数
	        config.setMaxWaitMillis(1000l); 
	        config.setTestOnBorrow(false); 
	        jedisPool = new JedisPool(config,"127.0.0.1",6379);
	    }
	    
	    /** 
	     * 初始化切片池 
	     */ 
	    public void initialShardedPool() 
	    { 
	        // 池基本配置 
	        JedisPoolConfig config = new JedisPoolConfig(); 
	        config.setMaxTotal(20); 
	        config.setMaxIdle(5); 
	        config.setMaxWaitMillis(10001); 
	        config.setTestOnBorrow(false); 
	        // slave链接 
	        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
	        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master")); 
	        // 构造池 
	        shardedJedisPool = new ShardedJedisPool(config, shards); 
	    } 

}
