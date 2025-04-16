package org.gycoding.heraldsofchaos.infrastructure.api.dto.in.items;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.gycoding.heraldsofchaos.domain.model.items.ItemType;

@Builder
public record ItemRQDTO(
        TranslatedString name,
        TranslatedString description,
        String image,
        ItemType type
) { }