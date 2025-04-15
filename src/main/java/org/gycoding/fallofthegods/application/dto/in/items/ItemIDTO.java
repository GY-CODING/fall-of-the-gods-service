package org.gycoding.fallofthegods.application.dto.in.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.items.ItemType;

import java.util.List;

@Builder
public record ItemIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame,
        ItemType type,
        List<ItemIDTO> fragments
) {}
