package org.gycoding.fallofthegods.infrastructure.api.dto.out.worlds;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record WorldRSDTO(
        String identifier,
        String name,
        String description,
        String image,
        String detailedIcon,
        String mainColor,
        List<PlaceRSDTO> places
) { }