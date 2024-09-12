package org.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;

@Builder
public record EntityAttribute(
        String name,
        String desc,
        String identifier
) {
    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\"," +
                "\"desc\": \"" + desc + "\"" +
                "\"identifier\": \"" + identifier + "\"" +
                "}";
    }
}
