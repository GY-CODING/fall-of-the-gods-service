package org.gycoding.fallofthegods.model.entities.items;

import lombok.Builder;
import org.gycoding.fallofthegods.model.entities.TranslatedString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.gycoding.fallofthegods.model.entities.EntityStat;

import java.util.List;
import java.util.Map;

@Builder
@Document(collection = "Item")
public record EntityItem(
    @Id
    String mongoId,
    String identifier,
    TranslatedString name,
    TranslatedString description,
    String image,
    Boolean inGame,
    ItemType type,
    List<EntityItem> fragments,
    EntityStat<EntityItemStat> stats
) {}
