package com.gycoding.fallofthegods.model.entities.achievements;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Builder
@Document(collection = "User")
public record EntityUser(
        @Id
        String mongoId,
        String identifier,
        String username,
        String email,
        @DBRef
        List<EntityAchievement> achievements
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"username\": \"" + username + "\"," +
                "\"email\": \"" + email + "\"," +
                "\"achievements\": " + achievements +
                "}";
    }
}
