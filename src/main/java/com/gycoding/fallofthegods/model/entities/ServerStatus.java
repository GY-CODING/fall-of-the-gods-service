package com.gycoding.fallofthegods.model.entities;

public enum ServerStatus {
    NOT_FOUND(-1);

    private final int status;

    private ServerStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.valueOf(status);
    }
}
