package org.gycoding.heraldsofchaos.application.dto.in.worlds;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

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
