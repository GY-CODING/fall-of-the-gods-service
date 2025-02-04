package org.gycoding.fallofthegods.infrastructure.api.dto.out.characters;

import lombok.Builder;

@Builder
public record AbilityRSDTO(
        String name,
        String description,
        String identifier,
        Double damage,
        Double life,
        Double cooldown,
        Double timeToHit
) {
    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\"," +
                "\"description\": \"" + description + "\"" +
                "\"identifier\": \"" + identifier + "\"" +
                "\"damage\": " + damage + "," +
                "\"life\": " + life + "," +
                "\"cooldown\": " + cooldown + "," +
                "\"timeToHit\": " + timeToHit +
                "}";
    }
}
