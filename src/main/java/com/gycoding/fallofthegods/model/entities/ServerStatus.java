package com.gycoding.fallofthegods.model.entities;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// TODO. Lists not found.
public enum ServerStatus {
    HOME_NOT_FOUND("API reference not found.", HttpStatus.NOT_FOUND),
    CHARACTER_NOT_FOUND("Character not found.", HttpStatus.NOT_FOUND),
    ITEM_NOT_FOUND("Item not found.", HttpStatus.NOT_FOUND),
    WORLD_NOT_FOUND("World not found.", HttpStatus.NOT_FOUND),
    PLACE_NOT_FOUND("Place not found.", HttpStatus.NOT_FOUND),
    STORY_NOT_FOUND("Story not found.", HttpStatus.NOT_FOUND),
    BAD_REQUEST("The endpoint is malformed.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("An internal server error has occurred, sorry for the inconvenience.", HttpStatus.INTERNAL_SERVER_ERROR);

    @Getter
    public final String msg;
    @Getter
    public final HttpStatus status;

    private ServerStatus(String msg, HttpStatus status) {
        this.msg    = msg;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("{\n\t\"error\": \"%s\",\n\n\t\"status\": %d,\n\t\"message\": \"%s\"}", this.status.getReasonPhrase().toUpperCase(), this.status.value(), this.msg);
    }
}
