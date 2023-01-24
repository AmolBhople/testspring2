package com.junitexample.spring3Junit.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("as", "firstN", "lastN", 23, "a@a.com");
    }

    @Test
    void groupAssertions(){
        assertAll( "test all user properties",
        () -> assertEquals("firstN", user.getFirstName(), () -> "this is longerMessage for failure"),
                () -> assertEquals("lastN", user.getLastName())
        );

        assertAll( "test all user properties",
                () -> assertAll("TestNames",
                        () -> assertEquals("firstName2", user.getFirstName(), () -> "this is longerMessage for failure"),
                        () -> assertEquals("lastNvvc", user.getLastName())),
                () ->assertAll( "TestEmail and age",
                        () -> assertEquals(26, user.getAge(), () -> "this is longerMessage for failure"),
                        () -> assertEquals("a@a.comvb", user.getEmail()))
        );
    }
}