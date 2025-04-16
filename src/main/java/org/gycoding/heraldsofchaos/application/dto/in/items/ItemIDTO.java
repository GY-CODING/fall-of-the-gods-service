package org.gycoding.heraldsofchaos.application.dto.in.items;

import lombok.Builder;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.gycoding.heraldsofchaos.domain.model.items.ItemType;

@Builder
public record ItemIDTO(
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        ItemType type
) {}
