package com.example.demo.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;

/**
 * @author panghu
 * @Title: RedisTemplate
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-5 上午11:01
 */
public class RedisTemplate extends org.springframework.data.redis.core.RedisTemplate {

    public static ThreadLocal<Integer> indexdb = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = indexdb.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                if (connection instanceof JedisConnection) {
                    if (((JedisConnection) connection).getNativeConnection().getDB().intValue() != dbIndex) {
                        connection.select(dbIndex);
                    }
                } else {
                    connection.select(dbIndex);
                }
            } else {
                connection.select(0);
            }
        } finally {
            indexdb.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }

}
