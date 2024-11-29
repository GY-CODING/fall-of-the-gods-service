package org.gycoding.fallofthegods.model.entities.characters;

import java.util.List;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.gycoding.fallofthegods.model.entities.EntityStat;
import org.gycoding.fallofthegods.model.entities.worlds.EntityWorld;

import java.util.Map;

@Builder
@Document(collection = "Character")
public record EntityCharacter(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString title,
        TranslatedString description,
        EntityWorld world,
        Boolean inGame,
        String image,
        EntityStat<Double> stats,
        EntityAbility ability,
        TranslatedString race,
        List<EntityAttribute> attributes
) {}

