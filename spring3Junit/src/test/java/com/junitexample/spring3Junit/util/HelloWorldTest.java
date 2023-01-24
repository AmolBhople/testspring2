package com.junitexample.spring3Junit.util;

import io.micrometer.observation.Observation;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class HelloWorldTest {
    private HelloWorld helloWorld;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All...............");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before Each..");
        helloWorld = new HelloWorld();
    }

    @AfterEach
    void tearDown(){
        System.out.println("After Each..");
    }

    @Test
    void helloWorld() {
        System.out.println("test 1 started");
        assertEquals("Hello World", helloWorld.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println("test 2 started");
        assertEquals("Hello Amol", helloWorld.helloWorld("YoYo"));
    }

    @Test
    void lambdaUseForMessage() {
        assertEquals("Hello World1", helloWorld.helloWorld(),
                () -> "this is a lambda message build using supplier");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All..........");
    }
}