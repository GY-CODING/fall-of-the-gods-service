package org.gycoding.fallofthegods.domain.model;

import lombok.Builder;

@Builder
public record TranslatedString (
        String es,
        String en
) {
    public static String EN = "en";
    public static String ES = "es";

    public String get(String language) {
        return switch (language) {
            case "en" -> en;
            case "es" -> es;
            default -> en;
        };
    }
}
