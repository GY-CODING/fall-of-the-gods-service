package org.gycoding.heraldsofchaos.infrastructure.external.database.model.creatures;

import lombok.Builder;
import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Creature")
public record CreatureEntity(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}

