package com.junitexample.spring3Junit.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class User implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
