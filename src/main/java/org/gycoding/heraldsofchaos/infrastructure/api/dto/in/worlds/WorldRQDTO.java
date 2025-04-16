package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.worlds;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;

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