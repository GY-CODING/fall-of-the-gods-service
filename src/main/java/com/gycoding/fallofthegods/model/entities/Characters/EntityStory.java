package com.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Builder
@Document(collection = "Story")
public record EntityStory(
        @Id
        String mongoId,
        String identifier,
        String title,
        String text
) {
    @Override
    public String toString() {
        return "{" +
                "\"identifier\": \"" + identifier + "\"," +
                "\"title\": \"" + title + "\"," +
                "\"text\": \"" + text + "\"" +
                "}";
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "title", title,
                "text", text
        );
    }
}
