package org.gycoding.fallofthegods.infrastructure.external.database.model.characters;

import lombok.Builder;
import org.gycoding.fallofthegods.infrastructure.external.database.model.StatEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.gycoding.fallofthegods.infrastructure.external.database.model.worlds.WorldEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document(collection = "Character")
public record CharacterEntity(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        WorldEntity world,
        Boolean inGame,
        String image,
        StatEntity<Double> stats,
        List<AbilityEntity> abilities,
        TranslatedString race,
        List<AttributeEntity> attributes
) {}

