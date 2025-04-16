package org.gycoding.heraldsofchaos.application.dto.out.worlds;

import lombok.Builder;

import java.util.Map;

@Builder
public record PlaceODTO(
        String identifier,
        String name,
        String description,
        String image
) {
    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", image
        );
    }
}
