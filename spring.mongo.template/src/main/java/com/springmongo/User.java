package com.springmongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
