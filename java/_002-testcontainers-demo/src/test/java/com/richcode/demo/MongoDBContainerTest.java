package com.richcode.demo;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MongoDBContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MongoDBContainerTest {

    private final MongoDBContainer mongo =
            new MongoDBContainer("mongo:5.0.9");

    @Test
    public void shouldStartContainer() {
        mongo.start();

        assertTrue(mongo.isRunning());

        mongo.stop();
    }

}
