package org.gycoding.fallofthegods.model.entities.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum FOTGAPIError {
    HOME_NOT_FOUND("API reference not found.", HttpStatus.NOT_FOUND),
    I_AM_A_TEAPOT("What? I'm a teapot!.", HttpStatus.I_AM_A_TEAPOT),

    CHARACTER_NOT_FOUND("Character not found.", HttpStatus.NOT_FOUND),
    ITEM_NOT_FOUND("Item not found.", HttpStatus.NOT_FOUND),
    WORLD_NOT_FOUND("World not found.", HttpStatus.NOT_FOUND),
    PLACE_NOT_FOUND("Place not found.", HttpStatus.NOT_FOUND),
    STORY_NOT_FOUND("Story not found.", HttpStatus.NOT_FOUND),
    ACHIEVEMENT_NOT_FOUND("Achievement not found.", HttpStatus.NOT_FOUND),

    LIST_CHARACTER_NOT_FOUND("List of Characters not found.", HttpStatus.NOT_FOUND),
    LIST_ITEM_NOT_FOUND("List of Items not found.", HttpStatus.NOT_FOUND),
    LIST_WORLD_NOT_FOUND("List of Worlds not found.", HttpStatus.NOT_FOUND),
    LIST_PLACE_NOT_FOUND("List of Places not found.", HttpStatus.NOT_FOUND),
    LIST_STORY_NOT_FOUND("List of Stories not found.", HttpStatus.NOT_FOUND),
    LIST_ACHIEVEMENT_NOT_FOUND("List of Achievements not found.", HttpStatus.NOT_FOUND),

    USER_CREATED("User has been successfully created.", HttpStatus.CREATED),
    ACHIEVEMENT_ADDED("Achievement has been successfully added to the specified User.", HttpStatus.CREATED),
    ACHIEVEMENT_REMOVED("Achievement has been successfully removed from the specified User.", HttpStatus.OK),
    BAD_REQUEST("The endpoint is malformed.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("An internal server error has occurred, sorry for the inconvenience.", HttpStatus.INTERNAL_SERVER_ERROR);

    public final String code;
    public final String message;
    public final HttpStatus status;

    FOTGAPIError(String message, HttpStatus status) {
        this.code       = this.name();
        this.message    = message;
        this.status     = status;
    }
}
