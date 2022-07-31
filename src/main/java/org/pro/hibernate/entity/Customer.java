package org.pro.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Builder
public class Customer {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private String email;

    private String password;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
