package org.gycoding.fallofthegods.infrastructure.external.database.model.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Place")
public record PlaceEntity(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        Boolean inGame
) {}
