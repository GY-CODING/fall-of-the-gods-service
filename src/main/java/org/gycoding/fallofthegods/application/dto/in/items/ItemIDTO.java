package org.gycoding.fallofthegods.application.dto.in.items;

import lombok.Builder;
import org.gycoding.fallofthegods.application.dto.in.StatIDTO;
import org.gycoding.fallofthegods.domain.model.items.ItemType;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record ItemIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame,
        ItemType type,
        List<ItemIDTO> fragments,
        StatIDTO<ItemStatIDTO> stats
) {}
