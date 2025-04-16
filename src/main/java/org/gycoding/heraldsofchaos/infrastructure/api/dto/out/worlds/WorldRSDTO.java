package org.gycoding.heraldsofchaos.infrastructure.api.dto.out.worlds;

import lombok.Builder;

import java.util.List;

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