package com.richcode.demo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstIntegrationTest extends AbstractIntegrationTest {

    private final RedisCache sut =
            new RedisCache(redis.getHost(), redis.getFirstMappedPort());

    @Test
    public void shouldPutValue() {
        // given
        String key = "Batman";
        String value = "Bruce Wayne";

        // when
        sut.put(key, value);

        // then
        assertEquals(Optional.of(value), sut.get(key));
    }

}
