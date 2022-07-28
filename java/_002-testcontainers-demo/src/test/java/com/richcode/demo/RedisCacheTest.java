package com.richcode.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class RedisCacheTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(RedisCacheTest.class);

    @Container
    private final GenericContainer<?> redis =
            new GenericContainer<>(DockerImageName.parse("redis:7.0.4"))
                    .withLogConsumer(new Slf4jLogConsumer(LOGGER))
                    .withExposedPorts(6379)
                    .waitingFor(Wait.forListeningPort());

    private RedisCache sut;

    @BeforeEach
    public void beforeEach() {
        sut = new RedisCache(redis.getHost(), redis.getFirstMappedPort());
    }

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
