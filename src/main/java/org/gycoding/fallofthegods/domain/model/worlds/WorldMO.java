package org.gycoding.fallofthegods.domain.model.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

import java.util.List;

@Builder
public record WorldMO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        String mainColor,
        List<PlaceMO> places
) { }