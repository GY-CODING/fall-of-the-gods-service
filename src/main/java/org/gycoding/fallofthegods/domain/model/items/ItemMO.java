package org.gycoding.fallofthegods.domain.model.items;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;

@Builder
public record ItemMO(
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    ItemType type
) {}
