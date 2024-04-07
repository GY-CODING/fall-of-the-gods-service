package com.gycoding.fallofthegods.model.entities;

public enum ServerStatus {
    NOT_FOUND("Not found."),
    INVALID_TOKEN("Invalid API token."),
    INTERNAL_ERROR("An internal server error has occurred.");

    private final String status;

    private ServerStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
