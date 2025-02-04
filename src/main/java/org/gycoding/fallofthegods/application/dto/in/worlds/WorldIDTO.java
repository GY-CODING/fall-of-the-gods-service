package org.gycoding.fallofthegods.application.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record WorldIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        List<PlaceIDTO> places
) {}
