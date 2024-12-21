package org.gycoding.fallofthegods.model.entities.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum FOTGAPIError {
    RESOURCE_NOT_FOUND("This resource was not found.", HttpStatus.NOT_FOUND);

    public final String code;
    public final String message;
    public final HttpStatus status;

    FOTGAPIError(String message, HttpStatus status) {
        this.code       = this.name();
        this.message    = message;
        this.status     = status;
    }
}
