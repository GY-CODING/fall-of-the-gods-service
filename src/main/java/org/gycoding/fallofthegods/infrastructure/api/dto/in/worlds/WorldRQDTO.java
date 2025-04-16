package org.gycoding.fallofthegods.infrastructure.api.dto.in.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

import java.util.List;

@Builder
public record WorldRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        String mainColor,
        List<String> places
) { }