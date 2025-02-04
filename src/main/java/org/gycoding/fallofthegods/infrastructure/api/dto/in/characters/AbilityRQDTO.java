package org.gycoding.fallofthegods.infrastructure.api.dto.in.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

@Builder
public record AbilityRQDTO(
        TranslatedString name,
        TranslatedString description,
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
