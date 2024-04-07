package com.gycoding.fallofthegods.model.entities.accounts;

import jakarta.persistence.Embeddable;
import lombok.Builder;


@Embeddable
public record GYToken(String token) {
    @Builder
    public GYToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return this.token;
    }
}

