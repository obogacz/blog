package com.richcode.demo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondIntegrationTest extends AbstractIntegrationTest {

    private final RedisCache sut =
            new RedisCache(redis.getHost(), redis.getFirstMappedPort());

    @Test
    public void shouldReturnOptionalEmpty() {
        // given
        String key = "Joker";

        // when
        Optional<String> result = sut.get(key);

        // then
        assertEquals(Optional.empty(), result);
    }

}
