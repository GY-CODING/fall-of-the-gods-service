package org.gycoding.fallofthegods.model.entities.creatures;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
@Document(collection = "Creature")
public record EntityCreature(
        @Id
        String mongoId,
        String identifier,
        TranslatedString name,
        TranslatedString description,
        Boolean inGame,
        String image
) {}

