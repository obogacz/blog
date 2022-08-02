package com.richcode.demo;

import redis.clients.jedis.Jedis;

import java.util.Optional;

public class RedisCache {

    private final Jedis jedis;

    public RedisCache(Jedis jedis) {
        this.jedis = jedis;
    }

    public RedisCache(String host, int port) {
        this(new Jedis(host, port));
    }

    public void put(String key, String value) {
        jedis.set(key, value);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(jedis.get(key));
    }

}
