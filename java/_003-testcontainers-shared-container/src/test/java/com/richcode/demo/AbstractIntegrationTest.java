package com.richcode.demo;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class AbstractIntegrationTest {

    static final GenericContainer<?> redis =
            new GenericContainer<>(DockerImageName.parse("redis:7.0.4"))
                    .withExposedPorts(6379);

    static {
        redis.start();
    }

}
