package com.ch.down;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ch.pojo.KeyWord;
import com.ch.util.MysqlOperation;
import com.ch.util.RedisConnection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

public class HttpStatical {
	public void staticalCollect() throws SQLException{
		Jedis	 jedis =new RedisConnection().jedis;
    	ShardedJedis shardedJedis =new RedisConnection().shardedJedis;
    	MysqlOperation operation = new MysqlOperation();
    	Connection conn = operation.mysqlConn();
    	Statement st = conn.createStatement();
    	String sql = "";
    	List<KeyWord> list = operation.keyWordQuery(conn, st, sql);	
    	
	}
			 }
