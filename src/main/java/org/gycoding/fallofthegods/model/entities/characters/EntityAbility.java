package org.gycoding.fallofthegods.model.entities.characters;

import lombok.Builder;

@Builder
public record EntityAbility(
        String name,
        String desc,
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
                "\"desc\": \"" + desc + "\"" +
                "\"identifier\": \"" + identifier + "\"" +
                "\"damage\": " + damage + "," +
                "\"life\": " + life + "," +
                "\"cooldown\": " + cooldown + "," +
                "\"timeToHit\": " + timeToHit +
                "}";
    }
}
