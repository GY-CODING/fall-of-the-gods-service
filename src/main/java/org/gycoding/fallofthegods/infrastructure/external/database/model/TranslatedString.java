package org.gycoding.fallofthegods.infrastructure.external.database.model;

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
