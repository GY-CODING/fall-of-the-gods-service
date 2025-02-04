package org.gycoding.fallofthegods.domain.model.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

import java.util.List;

@Builder
public record ItemMO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    Boolean inGame,
    ItemType type,
    List<ItemMO> fragments,
    StatMO<ItemStatMO> stats
) {}
