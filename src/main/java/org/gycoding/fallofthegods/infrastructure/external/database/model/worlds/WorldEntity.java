package org.gycoding.fallofthegods.infrastructure.external.database.model.worlds;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document(collection = "World")
public record WorldEntity(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString description,
        String image,
        String detailedIcon,
        String mainColor,
        @DBRef
        List<PlaceEntity> places
) {}
