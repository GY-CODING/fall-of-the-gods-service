package org.gycoding.fallofthegods.model.entities;

import lombok.Builder;

@Builder
public record TranslatedString (
        String es,
        String en
) {
    public String get(String language) {
        return switch (language) {
            case "en" -> en;
            case "es" -> es;
            default -> en;
        };
    }
}
