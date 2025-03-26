package org.gycoding.heraldsofchaos.domain.model.items;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.StatMO;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

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
