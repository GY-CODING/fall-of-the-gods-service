package org.gycoding.fallofthegods.infrastructure.api.dto.in.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

@Builder
public record ItemRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame,
        ItemType type
) { }