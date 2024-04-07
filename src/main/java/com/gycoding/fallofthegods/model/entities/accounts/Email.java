package com.gycoding.fallofthegods.model.entities.accounts;

import java.util.StringTokenizer;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Email {
    public final static String EMAIL_REGEX   = "^[A-Za-z0-9+_.-]+@(.+)$";
    public final static String EMAIL_DELIM   = "@";

    @Getter
    @Setter
    private String email;

    @Transient
    @Getter
    @Setter
    private String identifier;

    @Transient
    @Getter
    @Setter
    private String service;

    @Builder
    public Email(String email) {
        this.email = email;

        this.processMail(email);
    }

    public Email() {}

    /**
     * Process the email to get the identifier and the service
     * @param email The email to process
     */
    private void processMail(String email) {
        StringTokenizer st = new StringTokenizer(email, EMAIL_DELIM);
        this.setIdentifier(st.nextToken());
        this.setService(st.nextToken());
    }
}