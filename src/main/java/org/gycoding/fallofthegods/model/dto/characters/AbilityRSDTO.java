package org.gycoding.fallofthegods.model.dto.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;

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
