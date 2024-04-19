package com.gycoding.fallofthegods.model.entities.accounts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Getter
    @Setter
    private String username;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String salt;

    @Column
    @Getter
    @Setter
    private UUID token;

    @Builder
    public User(String username, String email) {
        this.username       = username;
        this.email          = email;
    }

    public User() {}
}
