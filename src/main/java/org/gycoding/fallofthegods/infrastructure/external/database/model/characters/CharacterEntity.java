package org.gycoding.fallofthegods.infrastructure.external.database.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.WorldEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "Character")
public record CharacterEntity(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        @DBRef
        WorldEntity world,
        Boolean inGame,
        String image,
        TranslatedString race
) {}

