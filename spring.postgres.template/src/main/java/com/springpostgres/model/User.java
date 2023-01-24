package com.springpostgres.model;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class User implements Serializable {


    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
