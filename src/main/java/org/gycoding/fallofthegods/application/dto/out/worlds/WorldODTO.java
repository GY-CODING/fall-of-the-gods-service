package org.gycoding.fallofthegods.application.dto.out.worlds;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record WorldODTO(
        String identifier,
        String name,
        String description,
        String image,
        String detailedIcon,
        String mainColor,
        List<PlaceODTO> places
) {
    public Map<String, Object> toMap() {
        return Map.of(
                "identifier", identifier,
                "name", name,
                "description", description,
                "image", detailedIcon,
                "detailedIcon", detailedIcon,
                "mainColor", mainColor,
                "places", places
        );
    }
}
