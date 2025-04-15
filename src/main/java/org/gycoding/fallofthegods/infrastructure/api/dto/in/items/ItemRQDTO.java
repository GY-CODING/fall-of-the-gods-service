package org.gycoding.fallofthegods.infrastructure.api.dto.in.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

import java.util.List;

@Builder
public record ItemRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame,
        ItemType type,
        List<ItemRQDTO> fragments
) { }