package com.junitexample.spring3Junit.util;

public class HelloWorld {
    public static String HELLO = "Hello";
    public static String WORLD = "World";

    public String helloWorld (){
        return HELLO+" "+WORLD;
    }
    public String helloWorld (String name){
        return HELLO+" "+name;
    }
}
