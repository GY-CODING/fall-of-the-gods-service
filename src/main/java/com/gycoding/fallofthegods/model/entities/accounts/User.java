package com.gycoding.fallofthegods.model.entities.accounts;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    @Embedded
    @Getter
    @Setter
    private Email email;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String salt;

    @Embedded
    @Getter
    @Setter
    private GYToken token;

    @Builder
    public User(String username, Email email) {
        this.username       = username;
        this.email          = email;
    }

    public User() {}
}
