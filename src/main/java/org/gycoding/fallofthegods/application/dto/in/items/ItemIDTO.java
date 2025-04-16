package org.gycoding.fallofthegods.application.dto.in.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

@Builder
public record ItemIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        ItemType type
) {}
