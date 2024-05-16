package com.gycoding.fallofthegods.model.entities.exceptions;

import com.gycoding.fallofthegods.model.entities.ServerStatus;
import lombok.Getter;

@Getter
public class FOTGAPIException extends Exception {
    private final ServerStatus status;

    public FOTGAPIException(ServerStatus status) {
        super(status.message);
        this.status = status;
    }
}
